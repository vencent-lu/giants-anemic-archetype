#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.demo.api;

import ${package}.demo.domain.People;
import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageCondition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * PeopleService (People)服务API接口(对外提供服务)
 * date time: 2021-09-30 17:52:04
 * Copyright 2021 github.com/vencent-lu/giants-anemic-archetype Inc. All rights reserved.
 *
 * @author vencent-lu
 * @since 1.0
 */
@FeignClient("${parentArtifactId}-server")
@RequestMapping(value = "people-service")
public interface PeopleService {

    /**
     * 根据ID返回 People 实体信息，如果找不到返回 null
     *
     * @param peopleId 主键
     * @return ${package}.demo.domain.People
     * @throws BusinessException 业务异常
     */
    @GetMapping(value = "load-{peopleId}")
    People loadPeople(@PathVariable Integer peopleId) throws BusinessException;

    /**
     * 根据ID返回 People 实体信息，如果找不到 抛异常
     *
     * @param peopleId 主键
     * @return ${package}.demo.domain.People
     * @throws BusinessException 业务异常
     */
    @GetMapping(value = "find-{peopleId}")
    People findPeople(@PathVariable Integer peopleId) throws BusinessException;

    /**
     * 创建 People 实体
     *
     * @param people 实例对象
     * @return ${package}.demo.domain.People
     * @throws BusinessException 业务异常
     */
    @PostMapping(value = "create")
    People createPeople(@RequestBody People people) throws BusinessException;

    /**
     * 修改 People 实体
     *
     * @param people 实例对象
     * @return ${package}.demo.domain.People
     * @throws BusinessException 业务异常
     */
    @PutMapping(value = "update")
    People updatePeople(@RequestBody People people) throws BusinessException;

    /**
     * 通过主键删除 People 实体
     *
     * @param peopleId 主键
     * @throws BusinessException 业务异常
     */
    @DeleteMapping(value = "delete-{peopleId}")
    void deletePeople(@PathVariable Integer peopleId) throws BusinessException;

    /**
     * 查询 People 实体数据,按分页返回信息
     *
     * @param pageCondition 分页查询条件
     * @return ${package}.demo.domain.People 分页对象
     */
    @PostMapping(value = "search")
    Page<People> searchPeoples(@RequestBody PageCondition pageCondition);
}
