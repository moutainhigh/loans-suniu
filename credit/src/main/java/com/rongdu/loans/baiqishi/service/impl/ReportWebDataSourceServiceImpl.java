/**
 * Copyright 2015-2017 聚宝钱包 All rights reserved.
 */
package com.rongdu.loans.baiqishi.service.impl;

import com.rongdu.common.service.BaseService;
import com.rongdu.loans.baiqishi.manager.ReportWebDataSourceManager;
import com.rongdu.loans.baiqishi.service.ReportWebDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 白骑士-数据来源-业务逻辑实现类
 * @author sunda
 * @version 2017-08-14
 */
@Service("reportWebDataSourceService")
public class ReportWebDataSourceServiceImpl  extends BaseService implements  ReportWebDataSourceService{
	
	/**
 	* 白骑士-数据来源-实体管理接口
 	*/
	@Autowired
	private ReportWebDataSourceManager reportWebDataSourceManager;
	
}