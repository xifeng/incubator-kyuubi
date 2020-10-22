/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.kyuubi.operation

import org.apache.hive.service.rpc.thrift.{TRowSet, TTableSchema}

import org.apache.kyuubi.operation.FetchOrientation.FetchOrientation
import org.apache.kyuubi.operation.OperationType.OperationType
import org.apache.kyuubi.session.Session

class NoopOperation(typ: OperationType, session: Session)
  extends AbstractOperation(typ, session) {
  override protected def runInternal(): Unit = {}

  override protected def beforeRun(): Unit = {}

  override protected def afterRun(): Unit = {}

  override def cancel(): Unit = {}

  override def close(): Unit = {}

  override def getResultSetSchema: TTableSchema = new TTableSchema()

  override def getNextRowSet(order: FetchOrientation, rowSetSize: Int): TRowSet = new TRowSet()

  override def shouldRunAsync: Boolean = false
}