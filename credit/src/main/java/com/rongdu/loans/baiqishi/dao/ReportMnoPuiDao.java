/**
 *Copyright 2014-2017 聚宝钱包 All rights reserved.
 */
package com.rongdu.loans.baiqishi.dao;

import com.rongdu.common.persistence.BaseDao;
import com.rongdu.common.persistence.annotation.MyBatisDao;
import com.rongdu.loans.baiqishi.entity.ReportMnoPui;

/**
 * 白骑士-运营商分时间段统计数据-mnoPeriodUsedInfos-数据访问接口
 * @author sunda
 * @version 2017-08-14
 */
@MyBatisDao
public interface ReportMnoPuiDao extends BaseDao<ReportMnoPui,String> {
	
}