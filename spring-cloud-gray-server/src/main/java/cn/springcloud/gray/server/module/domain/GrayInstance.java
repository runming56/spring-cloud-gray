package cn.springcloud.gray.server.module.domain;

import cn.springcloud.gray.model.GrayStatus;
import cn.springcloud.gray.model.InstanceStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;


@ApiModel("实例的灰度信息")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GrayInstance {


    @ApiModelProperty("服务实例id")
    private String instanceId;
    @ApiModelProperty("服务id")
    private String serviceId;
    private String host;
    @ApiModelProperty("服务实例端口")
    private Integer port;
    @ApiModelProperty("最后更新时间")
    private Date lastUpdateDate;

    /**
     * 实例状态
     */
    @ApiModelProperty("服务实例状态")
    private InstanceStatus instanceStatus;
    /**
     * 灰度状态
     */
    @ApiModelProperty("灰度状态")
    private GrayStatus grayStatus;


}
