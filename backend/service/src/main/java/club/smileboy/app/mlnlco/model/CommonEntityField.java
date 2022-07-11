package club.smileboy.app.mlnlco.model;

import java.util.Date;

/**
 * @author JASONJ
 * @date 2022/7/10
 * @time 12:52
 * @description 通用的Entity field ....
 **/
public interface CommonEntityField {

    void setCreateTime(Date date);
    void setUpdateTime(Date date);
    void setCreateTimeStr(String dateStr);
    void setUpdateTimeStr(String dateStr);


    String getCreateTimeStr();
    String getUpdateTimeStr();
    Date getCreateTime();
    Date getUpdateTime();


}
