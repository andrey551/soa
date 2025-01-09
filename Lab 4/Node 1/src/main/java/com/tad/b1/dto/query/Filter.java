
package com.tad.b1.dto.query;

import com.tad.b1.entity.enums.WorkerParameter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Dau Cong Tuan Anh
 */
@Data
@Setter
@Getter
public class Filter {
    private WorkerParameter param;
    private String value;
    
    public Filter(WorkerParameter param, String value) {
        this.param = param;
        this.value = value;
    }
}
