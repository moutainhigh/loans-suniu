/**
 * Copyright 2015-2017 聚宝钱包 All rights reserved.
 */
package com.rongdu.loans.risk.service.impl;

import com.rongdu.common.service.BaseService;
import com.rongdu.loans.risk.manager.AutoApproveLogManager;
import com.rongdu.loans.risk.service.AutoApproveLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 自动审批日志-业务逻辑实现类
 * @author sunda
 * @version 2017-08-14
 */
@Service("autoApproveLogService")
public class AutoApproveLogServiceImpl  extends BaseService implements  AutoApproveLogService{
	
	/**
 	* 自动审批日志-实体管理接口
 	*/
	@Autowired
	private AutoApproveLogManager autoApproveLogManager;
	
}