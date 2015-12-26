/*
 * Copyright 2012-2015 CodeLibs Project and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.codelibs.fess.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.codelibs.core.lang.StringUtil;

public class CronExpressionValidator implements ConstraintValidator<CronExpression, String> {

    @Override
    public void initialize(CronExpression constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return determineValid(value);
    }

    protected boolean determineValid(String value) {
        if (StringUtil.isNotBlank(value) && !org.quartz.CronExpression.isValidExpression(value)) {
            return false;
        }
        return true;
    }

}
