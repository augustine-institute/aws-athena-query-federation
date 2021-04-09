/*-
 * #%L
 * athena-jdbc
 * %%
 * Copyright (C) 2019 Amazon Web Services
 * %%
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
 * #L%
 */
package com.amazonaws.connectors.athena.jdbc.mariadb;

import com.amazonaws.connectors.athena.jdbc.connection.DatabaseConnectionConfig;
import com.amazonaws.connectors.athena.jdbc.connection.JdbcConnectionFactory;
import com.amazonaws.connectors.athena.jdbc.manager.JDBCUtil;
import com.amazonaws.connectors.athena.jdbc.mysql.MySqlRecordHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Data handler, user must have necessary permissions to read from necessary tables.
 */
public class MariaDbRecordHandler
        extends MySqlRecordHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MariaDbRecordHandler.class);

    /**
     * Instantiates handler to be used by Lambda function directly.
     *
     * Recommend using {@link com.amazonaws.connectors.athena.jdbc.MultiplexingJdbcCompositeHandler} instead.
     */
    public MariaDbRecordHandler()
    {
        this(JDBCUtil.getSingleDatabaseConfigFromEnv(JdbcConnectionFactory.DatabaseEngine.MARIADB));
    }

    public MariaDbRecordHandler(final DatabaseConnectionConfig databaseConnectionConfig)
    {
        super(databaseConnectionConfig);
    }
}
