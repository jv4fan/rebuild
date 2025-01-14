/*!
Copyright (c) REBUILD <https://getrebuild.com/> and/or its owners. All rights reserved.

rebuild is dual-licensed under commercial and open source licenses (GPLv3).
See LICENSE and COMMERCIAL in the project root for license information.
*/

package com.rebuild.core.service.notification;

import cn.devezhao.persist4j.engine.ID;
import com.rebuild.core.privileges.UserService;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * 通知消息。
 * 注意：若指定了 relatedRecord 相关记录删除时消息也将被删除
 *
 * @author devezhao
 * @since 10/17/2018
 */
@Data
@Setter(AccessLevel.NONE)
public class Message {

    // 未分类
    public static final int TYPE_DEFAULT = 0;
    // 分配消息
    public static final int TYPE_ASSIGN = 10;
    // 共享消息
    public static final int TYPE_SAHRE = 11;
    // 审批消息
    public static final int TYPE_APPROVAL = 20;
    // 动态
    public static final int TYPE_FEEDS = 30;
    // 项目-任务
    public static final int TYPE_PROJECT = 40;

    private ID fromUser;
    private ID toUser;
    private String message;
    private int type;
    private ID relatedRecord;

    /**
     * @param fromUser
     * @param toUser
     * @param message
     * @param type
     * @param relatedRecord
     */
    public Message(ID fromUser, ID toUser, String message, int type, ID relatedRecord) {
        this.fromUser = fromUser == null ? UserService.SYSTEM_USER : fromUser;
        this.toUser = toUser;
        this.message = message;
        this.type = type;
        this.relatedRecord = relatedRecord;
    }
}
