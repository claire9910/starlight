/*
 * Copyright (c) 2018 Baidu, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.baidu.brpc.spring.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation publish for {@link com.baidu.brpc.spring.RpcProxyFactoryBean}.
 *
 * @author xiemalin
 * @since 2.17
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface RpcProxy {

    /**
     * bean name of RPC client options.  bean type must be {@link com.baidu.brpc.client.RpcClientOptions}
     *
     * @return the string
     */
    String rpcClientOptionsBeanName() default "";

    /**
     * RPC server naming url to connect.
     *
     * @return the string
     */
    String namingServiceUrl() default "";

    /**
     * group for naming service
     *
     */
    String group() default "normal";

    /**
     * version for naming service
     *
     */
    String version() default "1.0.0";

    /**
     * ignore it when failed to lookup/subscribe naming service
     *
     * @return true, ignore
     */
    boolean ignoreFailOfNamingService() default false;
    
    /**
     * bean name of RPC interceptor bean type must be {@link com.baidu.brpc.interceptor.Interceptor}.
     *
     * @return the string
     */
    String interceptorBeanName() default "";

    /**
     * use name to identify all the instances for this service from registry.
     */
    String name() default "";
}