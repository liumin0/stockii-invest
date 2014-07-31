// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package com.cloud.network.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import org.springframework.stereotype.Component;
import com.cloud.utils.crypt.DBEncryptionUtil;
import com.cloud.utils.db.GenericDaoBase;
import com.cloud.utils.db.SearchBuilder;
import com.cloud.utils.db.SearchCriteria;
import com.cloud.utils.db.Transaction;

@Component
@Local(value=PhysicalNetworkDetailsDao.class)
public class PhysicalNetworkDetailsDaoImpl extends GenericDaoBase<PhysicalNetworkDetailVO, Long> implements PhysicalNetworkDetailsDao {
    protected final SearchBuilder<PhysicalNetworkDetailVO> networkSearch;
    protected final SearchBuilder<PhysicalNetworkDetailVO> DetailSearch;
    
    public PhysicalNetworkDetailsDaoImpl() {
    	networkSearch = createSearchBuilder();
    	networkSearch.and("physicalNetworkId", networkSearch.entity().getPhysicalNetworkId(), SearchCriteria.Op.EQ);
    	networkSearch.done();
        
        DetailSearch = createSearchBuilder();
        DetailSearch.and("physicalNetworkId", DetailSearch.entity().getPhysicalNetworkId(), SearchCriteria.Op.EQ);
        DetailSearch.and("name", DetailSearch.entity().getName(), SearchCriteria.Op.EQ);
        DetailSearch.done();
    }

    @Override
    public PhysicalNetworkDetailVO findDetail(long networkId, String name) {
        SearchCriteria<PhysicalNetworkDetailVO> sc = DetailSearch.create();
        sc.setParameters("physicalNetworkId", networkId);
        sc.setParameters("name", name);
        
        return findOneIncludingRemovedBy(sc);
    }

    @Override
    public Map<String, String> findDetails(long networkId) {
        SearchCriteria<PhysicalNetworkDetailVO> sc = networkSearch.create();
        sc.setParameters("physicalNetworkId", networkId);
        
        List<PhysicalNetworkDetailVO> results = search(sc, null);
        Map<String, String> details = new HashMap<String, String>(results.size());
        for (PhysicalNetworkDetailVO result : results) {
        	String value = result.getValue();
            if("h3c.imc.password".equals(result.getName())){
                value = DBEncryptionUtil.decrypt(value);
            }
            details.put(result.getName(), value);
        }
        return details;
    }
    
    @Override
    public void deleteDetails(long networkId) {
        SearchCriteria sc = networkSearch.create();
        sc.setParameters("physicalNetworkId", networkId);
        
        List<PhysicalNetworkDetailVO> results = search(sc, null);
        for (PhysicalNetworkDetailVO result : results) {
        	remove(result.getId());
        }
    }

    @Override
    public void persist(long networkId, Map<String, String> details) {
        Transaction txn = Transaction.currentTxn();
        txn.start();
        SearchCriteria<PhysicalNetworkDetailVO> sc = networkSearch.create();
        sc.setParameters("physicalNetworkId", networkId);
        expunge(sc);
        
        for (Map.Entry<String, String> detail : details.entrySet()) {
            String value = detail.getValue();
            if("h3c.imc.password".equals(detail.getKey())){
                value = DBEncryptionUtil.encrypt(value);
            }
            
            PhysicalNetworkDetailVO vo = new PhysicalNetworkDetailVO(networkId, detail.getKey(), value);
            persist(vo);
        }
        txn.commit();
    }
}
