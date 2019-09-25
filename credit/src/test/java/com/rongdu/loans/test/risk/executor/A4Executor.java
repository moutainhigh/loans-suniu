package com.rongdu.loans.test.risk.executor;

import com.rongdu.loans.risk.common.AutoApproveContext;
import com.rongdu.loans.risk.common.Executor;
import com.rongdu.loans.risk.common.RuleIds;


public class A4Executor extends Executor {

	public void init() {
		setRuleId(RuleIds.R1005);
	}

	@Override
	public void doExecute(AutoApproveContext context) {
		System.out.println("A4>doExecute：");
	}

}
