package mf_offer_system.springboot_02.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Create By WeiBin on 2020/5/11 20:51
 * @author WB
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> implements Serializable {
        private String code;
        private String msg;
        private T t;
        public JsonResult(String code,String msg){
            this.code=code;
            this.msg=msg;
        }
}
