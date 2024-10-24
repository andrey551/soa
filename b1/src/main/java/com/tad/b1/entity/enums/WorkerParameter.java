
package com.tad.b1.entity.enums;

/**
 *
 * @author Dau Cong Tuan Anh
 */
public enum WorkerParameter {
    ID,
    NAME, 
    COORDINATES,
    X,
    Y,
    CREATION_DATE, 
    SALARY, 
    START_DATE, 
    END_DATE, 
    STATUS, 
    PERSON,
    WEIGHT,
    PASSPORT_ID,
    EYE_COLOR,
    HAIR_COLOR;
    
    public String value() {
        return name();
    }
    
    public static WorkerParameter fromValue(String v) {
        return valueOf(v);
    }
}
