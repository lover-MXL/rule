package com.myself.service.impl;

import com.myself.entity.TableConfig;
import com.myself.mapper.HandTableInfoMapper;
import com.myself.mapper.TableConfigMapper;
import com.myself.service.HandTableInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Wang Yu Qiang
 * @Description:
 * @Date: Create in 13:45 2019/5/5
 */
@Service
public class HandTableInfoServiceImpl implements HandTableInfoService {


    @Autowired
    private HandTableInfoMapper handTableInfoMapper;

    @Autowired
    private TableConfigMapper tableConfigMapper;

    /**
     * 查询所有自建表的名称
     *
     * @return
     */
    @Override
    public List<String> showTables() {
        return handTableInfoMapper.showTables();
    }

    @Override
    public void insert(TableConfig tableConfig) {
        tableConfigMapper.insert(tableConfig);
    }
}
