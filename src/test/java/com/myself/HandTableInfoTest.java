package com.myself;

import com.myself.entity.TableConfig;
import com.myself.service.HandTableInfoService;
import com.myself.util.JsonPluginsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @Author: Wang Yu Qiang
 * @Description:
 * @Date: Create in 13:47 2019/5/5
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class HandTableInfoTest {

    @Autowired
    private HandTableInfoService handTableInfoService;

//    @Test
//    public void showTables() {
//        List<String> tables = handTableInfoService.showTables();
//        System.out.println(JsonPluginsUtil.listToJson(tables));
//    }

    @Test
    public void insert() {
        TableConfig tableConfig=new TableConfig();
        tableConfig.setTalbleName("demo");
        tableConfig.setTableKey("data");
        tableConfig.setCreateTime(new Date());
        handTableInfoService.insert(tableConfig);
    }
}
