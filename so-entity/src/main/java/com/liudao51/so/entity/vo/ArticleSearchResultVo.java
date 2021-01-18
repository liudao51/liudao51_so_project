package com.liudao51.so.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 文章搜索结果
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ArticleSearchResultVo", description = "文章搜索结果")
public class ArticleSearchResultVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章id")
    @TableId(value = "article_id")
    private Long articleId;

    @ApiModelProperty(value = "标题")
    @TableField(value = "title")
    private String title;

    @ApiModelProperty(value = "描述")
    @TableField(value = "description")
    private String description;

    @ApiModelProperty(value = "站点url")
    @TableField(value = "site_url")
    private String siteUrl;

    @ApiModelProperty(value = "关键词列表")
    @TableField(value = "keywords")
    private List<String> keywords;

    @ApiModelProperty(value = "文章快照id")
    @TableField(value = "article_snapshot_id")
    private Long articleSnapshotId;

    @ApiModelProperty(value = "快照时间")
    @TableField(value = "snapshot_updated_time")
    private Long snapshotUpdatedTime;
}
