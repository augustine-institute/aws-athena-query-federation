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
import com.amazonaws.connectors.athena.jdbc.mysql.MySqlMetadataHandler;
import com.amazonaws.services.athena.AmazonAthena;
import com.amazonaws.services.secretsmanager.AWSSecretsManager;
import com.google.common.annotations.VisibleForTesting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles metadata for MariaDb. User must have access to `schemata`, `tables`, `columns`, `partitions` tables in
 * information_schema.
 */
public class MariaDbMetadataHandler
        extends MySqlMetadataHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(MariaDbMetadataHandler.class);

    /**
     * Instantiates handler to be used by Lambda function directly.
     *
     * Recommend using {@link com.amazonaws.connectors.athena.jdbc.MultiplexingJdbcCompositeHandler} instead.
     */
    public MariaDbMetadataHandler()
    {
        this(JDBCUtil.getSingleDatabaseConfigFromEnv(JdbcConnectionFactory.DatabaseEngine.MARIADB));
    }

    /**
     * Used by Mux.
     */
    public MariaDbMetadataHandler(final DatabaseConnectionConfig databaseConnectionConfig)
    {
        super(databaseConnectionConfig);
    }

    @VisibleForTesting
    protected MariaDbMetadataHandler(final DatabaseConnectionConfig databaseConnectionConfig, final AWSSecretsManager secretsManager,
            AmazonAthena athena, final JdbcConnectionFactory jdbcConnectionFactory)
    {
        super(databaseConnectionConfig, secretsManager, athena, jdbcConnectionFactory);
    }
}
