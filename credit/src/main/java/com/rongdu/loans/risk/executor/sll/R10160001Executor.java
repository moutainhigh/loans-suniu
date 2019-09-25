package com.rongdu.loans.risk.executor.sll;

import com.rongdu.loans.risk.common.AutoApproveContext;
import com.rongdu.loans.risk.common.Executor;
import com.rongdu.loans.risk.common.RuleIds;
import com.rongdu.loans.risk.entity.HitRule;
import com.rongdu.loans.thirdpartycredit1.vo.ThirdPartyCredit1BlackListVO;

/**
 * 三方征信1黑名单
 * 
 * @author liuzhuang
 * @version 2018-03-26
 */
public class R10160001Executor extends Executor {

	@Override
	public void init() {
		super.setRuleId(RuleIds.R10160001);
	}

	@Override
	public void doExecute(AutoApproveContext context) {
		// 加载风险分析数据
		ThirdPartyCredit1BlackListVO vo = null;
		try {
			vo = getDataInvokeService().getThirdPartyCredit1Blacklist(context);
		} catch (Exception e) {
			logger.error("三方征信1查询黑名单异常", e);
		}
		if (vo == null)
			return;
		// 命中的规则
		HitRule hitRule = checkBlackList(vo);
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
	 * 黑名单
	 * 
	 * @param blackList
	 * @return
	 */
	private HitRule checkBlackList(ThirdPartyCredit1BlackListVO vo) {
		HitRule hitRule = createHitRule(getRiskRule());
		if (vo != null && vo.isSuccess()) {
			if ("Y".equals(vo.getResult())) {
				setHitNum(1);
				hitRule.setRemark("命中三方征信1黑名单");
			}
		}
		return hitRule;
	}

}
