/*
 * Copyright 2010-2013 Ning, Inc.
 *
 * Ning licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.subscription.api.user;

import java.util.UUID;

import org.joda.time.DateTime;

import com.ning.billing.entitlement.api.BlockingState;
import com.ning.billing.util.entity.EntityBase;

public class DefaultSubscriptionBaseBundle extends EntityBase implements SubscriptionBaseBundle {

    private final String key;
    private final UUID accountId;
    private final DateTime lastSysUpdateDate;

    public DefaultSubscriptionBaseBundle(final String name, final UUID accountId, final DateTime startDate) {
        this(UUID.randomUUID(), name, accountId, startDate);
    }


    public DefaultSubscriptionBaseBundle(final UUID id, final String key, final UUID accountId, final DateTime lastSysUpdate) {
        // TODO add column in bundles table
        super(id, null, null);
        this.key = key;
        this.accountId = accountId;
        this.lastSysUpdateDate = lastSysUpdate;
    }

    @Override
    public String getExternalKey() {
        return key;
    }

    @Override
    public UUID getAccountId() {
        return accountId;
    }

    public DateTime getLastSysUpdateDate() {
        return lastSysUpdateDate;
    }

    @Override
    public BlockingState getBlockingState() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DefaultSubscriptionBaseBundle");
        sb.append("{accountId=").append(accountId);
        sb.append(", id=").append(id);
        sb.append(", key='").append(key).append('\'');
        sb.append(", lastSysUpdateDate=").append(lastSysUpdateDate);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final DefaultSubscriptionBaseBundle that = (DefaultSubscriptionBaseBundle) o;

        if (accountId != null ? !accountId.equals(that.accountId) : that.accountId != null) {
            return false;
        }
        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (key != null ? !key.equals(that.key) : that.key != null) {
            return false;
        }
        if (lastSysUpdateDate != null ? !lastSysUpdateDate.equals(that.lastSysUpdateDate) : that.lastSysUpdateDate != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        result = 31 * result + (lastSysUpdateDate != null ? lastSysUpdateDate.hashCode() : 0);
        return result;
    }
}
