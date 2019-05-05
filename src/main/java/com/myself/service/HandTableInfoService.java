package com.myself.service;

import com.myself.entity.TableConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Wang Yu Qiang
 * @Description:
 * @Date: Create in 13:42 2019/5/5
 */
public interface HandTableInfoService {

    public List<String> showTables();

    void insert(TableConfig tableConfig);
}
