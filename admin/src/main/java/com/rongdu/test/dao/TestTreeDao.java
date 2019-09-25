/**
 *Copyright 2014-2017 聚宝钱包 All rights reserved.
 */
package com.rongdu.test.dao;

import com.rongdu.common.persistence.TreeDao;
import com.rongdu.common.persistence.annotation.MyBatisDao;
import com.rongdu.test.entity.TestTree;

/**
 * 树结构生成DAO接口
 * @author sunda
 * @version 2015-04-06
 */
@MyBatisDao
public interface TestTreeDao extends TreeDao<TestTree> {
	
}