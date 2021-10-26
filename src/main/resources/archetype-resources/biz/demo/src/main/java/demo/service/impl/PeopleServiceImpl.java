#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.demo.service.impl;

import ${package}.demo.domain.People;
import ${package}.demo.dao.PeopleDao;
import ${package}.demo.service.PeopleService;
import com.giants.common.exception.BusinessException;
import com.giants.common.tools.Page;
import com.giants.common.tools.PageCondition;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * PeopleServiceImpl (People)服务实现类
 * date time: 2021-09-30 17:50:59
 * Copyright 2021 github.com/vencent-lu/giants-anemic-archetype Inc. All rights reserved.
 *
 * @author vencent-lu
 * @since 1.0
 */
@RestController
@RequestMapping(value = "people-service")
@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {
    @Resource
    private PeopleDao peopleDao;


    /**
     * 根据ID返回 People 实体信息，如果找不到返回 null
     *
     * @param peopleId 主键
     * @return ${package}.demo.domain.People
     * @throws BusinessException 业务异常
     */
    @Override
    @GetMapping(value = "load-{peopleId}")
    public People loadPeople(@PathVariable Integer peopleId) throws BusinessException {
        if (peopleId == null) {
            throw new BusinessException("peopleIdEmpty", "people.error.peopleIdEmpty");
        }
        return this.peopleDao.get(peopleId);
    }

    /**
     * 根据ID返回 People 实体信息，如果找不到 抛异常
     *
     * @param peopleId 主键
     * @return ${package}.demo.domain.People
     * @throws BusinessException 业务异常
     */
    @Override
    @GetMapping(value = "find-{peopleId}")
    public People findPeople(@PathVariable Integer peopleId) throws BusinessException {
        People people = this.loadPeople(peopleId);
        if (people == null) {
            throw new BusinessException("peopleInexistence", "people.error.peopleInexistence");
        }
        return people;
    }

    /**
     * 创建 People 实体
     *
     * @param people 实例对象
     * @return ${package}.demo.domain.People
     * @throws BusinessException 业务异常
     */
    @Override
    @PostMapping(value = "create")
    public People createPeople(@RequestBody People people) throws BusinessException {
        this.peopleDao.insert(people);
        return people;
    }

    /**
     * 修改 People 实体
     *
     * @param people 实例对象
     * @return ${package}.demo.domain.People
     * @throws BusinessException 业务异常
     */
    @Override
    @PutMapping(value = "update")
    public People updatePeople(@RequestBody People people) throws BusinessException {
        People peoplePo = this.findPeople(people.getPeopleId());
        //TODO 设置其它不可编辑属性
        this.peopleDao.update(people);
        return people;
    }

    /**
     * 通过主键删除 People 实体
     *
     * @param peopleId 主键
     * @throws BusinessException 业务异常
     */
    @Override
    @DeleteMapping(value = "delete-{peopleId}")
    public void deletePeople(@PathVariable Integer peopleId) throws BusinessException {
        People people = this.findPeople(peopleId);
        this.peopleDao.delete(people);
    }

    /**
     * 查询 People 实体数据,按分页返回信息
     *
     * @param pageCondition 分页查询条件
     * @return ${package}.demo.domain.People 分页对象
     */
    @Override
    @PostMapping(value = "search")
    public Page<People> searchPeoples(@RequestBody PageCondition pageCondition) {
        return new Page<People>(pageCondition.getPageNo(), pageCondition.getPageSize(),
                this.peopleDao.searchCount(pageCondition), this.peopleDao.search(pageCondition));
    }
}
