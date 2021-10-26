#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.demo.dao;

import ${package}.demo.domain.People;
import com.giants.dal.dao.mybatis.MybatisDao;

/**
 * PeopleDao (People)数据库访问层
 * date time: 2021-09-30 17:50:58
 * Copyright 2021 github.com/vencent-lu/giants-anemic-archetype Inc. All rights reserved.
 *
 * @author vencent-lu
 * @since 1.0
 */
public interface PeopleDao extends MybatisDao<People> {

}

