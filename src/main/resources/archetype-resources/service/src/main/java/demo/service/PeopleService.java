#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.demo.service;

import ${package}.demo.domain.People;
import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageCondition;

/**
 * PeopleService (People)服务接口
 * data time: 2021-09-30 17:50:01
 * Copyright 2021 github.com/vencent-lu/${parentArtifactId}-archetype Inc. All rights reserved.
 *
 * @author vencent-lu
 * @since 1.0
 */
public interface PeopleService {

    /**
     * 根据ID返回 People 实体信息，如果找不到返回 null
     *
     * @param peopleId 主键
     * @return ${package}.demo.domain.People
     * @throws BusinessException 业务异常
     */
    People loadPeople(Integer peopleId) throws BusinessException;

    /**
     * 根据ID返回 People 实体信息，如果找不到 抛异常
     *
     * @param peopleId 主键
     * @return ${package}.demo.domain.People
     * @throws BusinessException 业务异常
     */
    People findPeople(Integer peopleId) throws BusinessException;

    /**
     * 创建 People 实体
     *
     * @param people 实例对象
     * @return ${package}.demo.domain.People
     * @throws BusinessException 业务异常
     */
    People createPeople(People people) throws BusinessException;

    /**
     * 修改 People 实体
     *
     * @param people 实例对象
     * @return ${package}.demo.domain.People
     * @throws BusinessException 业务异常
     */
    People updatePeople(People people) throws BusinessException;

    /**
     * 通过主键删除 People 实体
     *
     * @param peopleId 主键
     * @throws BusinessException 业务异常
     */
    void deletePeople(Integer peopleId) throws BusinessException;

    /**
     * 查询 People 实体数据,按分页返回信息
     *
     * @param pageCondition 分页查询条件
     * @return ${package}.demo.domain.People 分页对象
     */
    Page<People> searchPeoples(PageCondition pageCondition);

}
