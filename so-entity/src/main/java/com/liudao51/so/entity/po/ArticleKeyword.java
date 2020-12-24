package com.liudao51.so.entity.po;

import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章关键词
 * </p>
 *
 * @author Jewel
 * @since 2020-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="ArticleKeyword对象", description="文章关键词")
public class ArticleKeyword implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章关键词id")
    @TableId(value = "id")
    private Long id;

    @ApiModelProperty(value = "文章id")
    @TableField(value = "article_id")
    private Long articleId;

    @ApiModelProperty(value = "内容")
    @TableField(value = "content")
    private String content;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "created_time")
    private Long createdTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "updated_time")
    private Long updatedTime;

    @ApiModelProperty(value = "版本(用于乐观锁)")
    @Version
    @TableField(value = "version")
    private Long version;
}
