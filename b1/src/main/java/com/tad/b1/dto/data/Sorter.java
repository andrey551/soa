
package com.tad.b1.dto.data;

import com.tad.b1.entity.enums.SortMode;
import com.tad.b1.entity.enums.WorkerParameter;

/**
 *
 * @author Dau Cong Tuan Anh
 */
public class Sorter {
    private WorkerParameter param;
    private SortMode mode;
    
    public Sorter(WorkerParameter param, SortMode mode) {
        this.param = param;
        this.mode = mode;
    }
}
