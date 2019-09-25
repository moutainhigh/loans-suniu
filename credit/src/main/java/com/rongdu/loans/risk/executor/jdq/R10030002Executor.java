package com.rongdu.loans.risk.executor.jdq;

import com.rongdu.loans.loan.option.jdq.IntoOrder;
import com.rongdu.loans.loan.option.jdq.MoxieTelecomReport;
import com.rongdu.loans.risk.common.AutoApproveContext;
import com.rongdu.loans.risk.common.Executor;
import com.rongdu.loans.risk.common.RuleIds;
import com.rongdu.loans.risk.entity.HitRule;

import java.util.List;

/**
 *
 * @Description: 手机号未实名认证 数据来源于：API
 * @author: 饶文彪
 * @date 2018年6月27日 下午4:08:19
 */
public class R10030002Executor extends Executor {

	@Override
	public void init() {
		super.setRuleId(RuleIds.R10030002);
	}

	@Override
	public void doExecute(AutoApproveContext context) {
		IntoOrder vo = null;
		try {
			vo = getDataInvokeService().getjdqBase(context);
		} catch (Exception e) {
			logger.error("JDQ基本信息查询异常", e);
		}
		if (vo == null) {
			return;
		}
		// 命中的规则
		HitRule hitRule = checkRule(vo.getMoxieTelecomReport().cell_phone);
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
	 * 判断手机号码是否经过实名认证
	 *
	 * @param cellPhoneBeans
	 * @return
	 */

	private HitRule checkRule(List<MoxieTelecomReport.CellPhoneBean> cellPhoneBeans){
		HitRule hitRule = createHitRule(getRiskRule());
		String  value = null;
		for (int i = 0; i < cellPhoneBeans.size(); i++) {
			if ("reliability".equals(cellPhoneBeans.get(i).key)) {
				value = cellPhoneBeans.get(i).value;
				break;
			}
		}
		if ("未实名".equals(value)) {
			setHitNum(1);
		}
		String msg = String.format("手机号未实名认证：%s", value);
		hitRule.setRemark(msg);
		return hitRule;
	}

//	private HitRule checkMobileRealName(JDQReport op, CustUserVO user) {
//		HitRule hitRule = createHitRule(getRiskRule());
//		// System.out.println(op.getUser_info().getUserIdcard() + ":" +
//		// user.getIdNo());
//		// System.out.println(op.getUser_info().getUserName() + ":" +
//		// user.getRealName());
//
//		// if
//		// (!checkUserIDCard(user.getIdNo(),op.getUser_info().getUserIdcard())
//		// || !checkUserName(user.getRealName(),
//		// op.getUser_info().getUserName())) {
//		// setHitNum(1);
//		// }
//		// hitRule.setRemark(String.format("姓名:%s；身份证号：%s",
//		// op.getUser_info().getUserName(),op.getUser_info().getUserIdcard()));
//
//		if (!checkUserIDCard(user.getIdNo(), op.getBasic().getIdcard())) {
//			setHitNum(1);
//		}
//		hitRule.setRemark(String.format("身份证号：%s vs %s", user.getIdNo(),
//				op.getBasic().getIdcard()));
//
//		return hitRule;
//	}
//
//	/**
//	 *
//	 * @Title: checkUserIDCard @Description: 判断身份证是否一致 @param IdCard @param
//	 *         xjbkIdCard 现金白卡身份证（带*） @return 设定文件 @return boolean 返回类型 @throws
//	 */
//	private boolean checkUserIDCard(String IdCard, String xjbkIdCard) {
//		if (StringUtils.isNotBlank(xjbkIdCard)) {
//			String[] nameArr = xjbkIdCard.split("\\*");
//
//			for (String str : nameArr) {
//				if (StringUtils.isNotBlank(str) && !IdCard.toLowerCase().contains(str.toLowerCase())) {
//					return false;
//				}
//			}
//		}
//
//		return true;
//	}
//
//	/**
//	 *
//	 * @Title: checkUserName @Description: 检查用户名是否匹配 @param name1 @param
//	 *         name2 @return 设定文件 @return boolean 返回类型 @throws
//	 */
//	private boolean checkUserName(String name1, String name2) {
//		name2 = name2.replace("*", "");
//
//		char[] char2 = name2.toCharArray();
//
//		for (int i = 0; i < char2.length; i++) {
//			if (!name1.contains(char2[i] + "")) {
//				return false;
//			}
//
//		}
//
//		return true;
//	}

}
