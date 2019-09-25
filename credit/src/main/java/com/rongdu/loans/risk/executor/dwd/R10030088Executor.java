package com.rongdu.loans.risk.executor.dwd;

import com.rongdu.loans.loan.option.dwd.report.Behavior;
import com.rongdu.loans.loan.option.dwd.report.Report;
import com.rongdu.loans.risk.common.AutoApproveContext;
import com.rongdu.loans.risk.common.Executor;
import com.rongdu.loans.risk.common.RuleIds;
import com.rongdu.loans.risk.entity.HitRule;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 近3个月通话总次数的月均值<=50或>=150
 *
 * @author fy
 * @version 2019-05-27
 */
public class R10030088Executor extends Executor {

    @Override
    public void init() {
        super.setRuleId(RuleIds.R10030088);
    }

    @Override
    public void doExecute(AutoApproveContext context) {
        // 加载聚信立分析报告数据
        Report report = getDataInvokeService().getdwdChargeInfo(context).getReportInfo().getData().getReport();
        if (report == null) {
            return;
        }
        // 命中的规则
        HitRule hitRule = checkRule(report);
        // 决策依据
        String evidence = hitRule.getRemark();
        // 命中规则的数量
        int hitNum = getHitNum();
        if (hitNum > 0) {
            addHitRule(context, hitRule);
        }
        logger.info("执行规则-【{}-{}】-{},{},命中规则的数量：{},决策依据：{}", getRuleId(), getRuleName(), context.getUserName(),
                context.getApplyId(), hitNum, evidence);
    }

    /**
     * 近3个月通话总次数的月均值<=50或>=150
     *
     * @param report
     * @return
     */
    private HitRule checkRule(Report report) {
        HitRule hitRule = createHitRule(getRiskRule());
        String remark = null;
        Integer count = 0;
        // 获取运营商月度报告
        if (report.getCellBehavior() != null && report.getCellBehavior().get(0).getBehavior() != null) {
            // 根据月度报告月份排序
            List<Behavior> behavior = report.getCellBehavior().get(0).getBehavior();
            Collections.sort(behavior, new Comparator<Behavior>() {
                @Override
                public int compare(Behavior o1, Behavior o2) {
                    // 倒序排序
                    return o2.getCellMth().compareTo(o1.getCellMth());
                }
            });
            // 截取前三个月的通话记录
            List<Behavior> behaviors = null;
            if (behavior.size() >= 3){
                behaviors = behavior.subList(0, 3);
            } else {
                behaviors = behavior;
            }
            // 统计近三个月通话总次数
            for (Behavior behaviorss : behaviors) {
                count += behaviorss.getCallCnt();
            }
            Double count3= Double.valueOf(count)/Double.valueOf(3);
//            if (count3 <= Double.valueOf(50) || count3 >= Double.valueOf(150) ) {
            if (count3 <= Double.valueOf(50) ) {
                setHitNum(1);
                remark = String.format("申请人近3个月通话总次数的月均值<=50，近三个月通话次数均值：%s", count3);
                hitRule.setRemark(remark);
            }
        } else {
            setHitNum(1);
            remark = "聚信立分析报告数据中运营商月度数据为空";
            hitRule.setRemark(remark);
        }
        return hitRule;
    }

}
