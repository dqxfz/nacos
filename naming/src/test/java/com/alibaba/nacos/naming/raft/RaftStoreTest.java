/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.nacos.naming.raft;

import com.alibaba.nacos.naming.consistency.persistent.raft.Datum;
import com.alibaba.nacos.naming.consistency.persistent.raft.RaftCore;
import com.alibaba.nacos.naming.consistency.persistent.raft.RaftStore;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

/**
 * @author nkorange
 */
public class RaftStoreTest {

    @Mock
    public RaftCore raftCore;

    @Test
    public void wrietDatum() throws Exception {

        Datum datum = new Datum();
        datum.key = "1.2.3.4";
        datum.value = "value1";

        RaftStore.write(datum);

        RaftStore.load("1.2.3.4");

        Datum result = raftCore.getDatum("1.2.3.4");

        Assert.assertNotNull(result);
        Assert.assertEquals("value1", result.value);
    }
}
