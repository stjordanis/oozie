/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.oozie.executor.jpa;

import javax.persistence.EntityManager;

import org.apache.oozie.CoordinatorActionBean;

import java.util.Objects;

/**
 * Persist the CoordinatorAction bean.
 */
public class CoordActionInsertJPAExecutor implements JPAExecutor<String> {

    private CoordinatorActionBean coordAction = null;

    public CoordActionInsertJPAExecutor(CoordinatorActionBean coordAction) {
        this.coordAction = Objects.requireNonNull(coordAction, "coordAction cannot be null");
    }

    @Override
    public String getName() {
        return "CoordActionInsertJPAExecutor";
    }

    @Override
    public String execute(EntityManager em) throws JPAExecutorException {
        em.persist(coordAction);
        return null;
    }
}
