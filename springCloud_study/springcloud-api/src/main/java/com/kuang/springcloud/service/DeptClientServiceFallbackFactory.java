package com.kuang.springcloud.service;

import com.kuang.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;

import java.util.List;

public class DeptClientServiceFallbackFactory implements FallbackFactory {

    // 降级
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setDeptId(id)
                        .setDname("id=>" + id + "没有对应的信息。客户端提供了降级的信息，这个服务现在已经关闭了")
                        .setDb_source("没有数据~");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
