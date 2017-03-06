/*
 * Copyright 2012-2017 CodeLibs Project and the Others.
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
package org.codelibs.fess.es.config.cbean.ca.bs;

import org.codelibs.fess.es.config.allcommon.EsAbstractConditionAggregation;
import org.codelibs.fess.es.config.allcommon.EsAbstractConditionQuery;
import org.codelibs.fess.es.config.cbean.ca.DataConfigToRoleCA;
import org.codelibs.fess.es.config.cbean.cq.DataConfigToRoleCQ;
import org.codelibs.fess.es.config.cbean.cq.bs.BsDataConfigToRoleCQ;
import org.elasticsearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.global.GlobalBuilder;
import org.elasticsearch.search.aggregations.bucket.missing.MissingBuilder;
import org.elasticsearch.search.aggregations.bucket.range.ipv4.IPv4RangeBuilder;
import org.elasticsearch.search.aggregations.bucket.sampler.SamplerAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.significant.SignificantTermsBuilder;
import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder;
import org.elasticsearch.search.aggregations.metrics.cardinality.CardinalityBuilder;
import org.elasticsearch.search.aggregations.metrics.scripted.ScriptedMetricBuilder;
import org.elasticsearch.search.aggregations.metrics.tophits.TopHitsBuilder;
import org.elasticsearch.search.aggregations.metrics.valuecount.ValueCountBuilder;

/**
 * @author ESFlute (using FreeGen)
 */
public abstract class BsDataConfigToRoleCA extends EsAbstractConditionAggregation {

    // ===================================================================================
    //                                                                     Aggregation Set
    //                                                                           =========

    public void filter(String name, EsAbstractConditionQuery.OperatorCall<BsDataConfigToRoleCQ> queryLambda,
            ConditionOptionCall<FilterAggregationBuilder> opLambda, OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        DataConfigToRoleCQ cq = new DataConfigToRoleCQ();
        if (queryLambda != null) {
            queryLambda.callback(cq);
        }
        FilterAggregationBuilder builder = regFilterA(name, cq.getQuery());
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            DataConfigToRoleCA ca = new DataConfigToRoleCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void global(String name, ConditionOptionCall<GlobalBuilder> opLambda, OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        GlobalBuilder builder = regGlobalA(name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            DataConfigToRoleCA ca = new DataConfigToRoleCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void sampler(String name, ConditionOptionCall<SamplerAggregationBuilder> opLambda, OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        SamplerAggregationBuilder builder = regSamplerA(name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            DataConfigToRoleCA ca = new DataConfigToRoleCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void scriptedMetric(String name, ConditionOptionCall<ScriptedMetricBuilder> opLambda) {
        ScriptedMetricBuilder builder = regScriptedMetricA(name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void topHits(String name, ConditionOptionCall<TopHitsBuilder> opLambda) {
        TopHitsBuilder builder = regTopHitsA(name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    // String dataConfigId

    public void setDataConfigId_Terms() {
        setDataConfigId_Terms(null);
    }

    public void setDataConfigId_Terms(ConditionOptionCall<TermsBuilder> opLambda) {
        setDataConfigId_Terms("dataConfigId", opLambda, null);
    }

    public void setDataConfigId_Terms(ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        setDataConfigId_Terms("dataConfigId", opLambda, aggsLambda);
    }

    public void setDataConfigId_Terms(String name, ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        TermsBuilder builder = regTermsA(name, "dataConfigId");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            DataConfigToRoleCA ca = new DataConfigToRoleCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setDataConfigId_SignificantTerms() {
        setDataConfigId_SignificantTerms(null);
    }

    public void setDataConfigId_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda) {
        setDataConfigId_SignificantTerms("dataConfigId", opLambda, null);
    }

    public void setDataConfigId_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        setDataConfigId_SignificantTerms("dataConfigId", opLambda, aggsLambda);
    }

    public void setDataConfigId_SignificantTerms(String name, ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        SignificantTermsBuilder builder = regSignificantTermsA(name, "dataConfigId");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            DataConfigToRoleCA ca = new DataConfigToRoleCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setDataConfigId_IpRange() {
        setDataConfigId_IpRange(null);
    }

    public void setDataConfigId_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda) {
        setDataConfigId_IpRange("dataConfigId", opLambda, null);
    }

    public void setDataConfigId_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        setDataConfigId_IpRange("dataConfigId", opLambda, aggsLambda);
    }

    public void setDataConfigId_IpRange(String name, ConditionOptionCall<IPv4RangeBuilder> opLambda,
            OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        IPv4RangeBuilder builder = regIpRangeA(name, "dataConfigId");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            DataConfigToRoleCA ca = new DataConfigToRoleCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setDataConfigId_Count() {
        setDataConfigId_Count(null);
    }

    public void setDataConfigId_Count(ConditionOptionCall<ValueCountBuilder> opLambda) {
        setDataConfigId_Count("dataConfigId", opLambda);
    }

    public void setDataConfigId_Count(String name, ConditionOptionCall<ValueCountBuilder> opLambda) {
        ValueCountBuilder builder = regCountA(name, "dataConfigId");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setDataConfigId_Cardinality() {
        setDataConfigId_Cardinality(null);
    }

    public void setDataConfigId_Cardinality(ConditionOptionCall<CardinalityBuilder> opLambda) {
        setDataConfigId_Cardinality("dataConfigId", opLambda);
    }

    public void setDataConfigId_Cardinality(String name, ConditionOptionCall<CardinalityBuilder> opLambda) {
        CardinalityBuilder builder = regCardinalityA(name, "dataConfigId");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setDataConfigId_Missing() {
        setDataConfigId_Missing(null);
    }

    public void setDataConfigId_Missing(ConditionOptionCall<MissingBuilder> opLambda) {
        setDataConfigId_Missing("dataConfigId", opLambda, null);
    }

    public void setDataConfigId_Missing(ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        setDataConfigId_Missing("dataConfigId", opLambda, aggsLambda);
    }

    public void setDataConfigId_Missing(String name, ConditionOptionCall<MissingBuilder> opLambda,
            OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        MissingBuilder builder = regMissingA(name, "dataConfigId");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            DataConfigToRoleCA ca = new DataConfigToRoleCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    // String roleTypeId

    public void setRoleTypeId_Terms() {
        setRoleTypeId_Terms(null);
    }

    public void setRoleTypeId_Terms(ConditionOptionCall<TermsBuilder> opLambda) {
        setRoleTypeId_Terms("roleTypeId", opLambda, null);
    }

    public void setRoleTypeId_Terms(ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        setRoleTypeId_Terms("roleTypeId", opLambda, aggsLambda);
    }

    public void setRoleTypeId_Terms(String name, ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        TermsBuilder builder = regTermsA(name, "roleTypeId");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            DataConfigToRoleCA ca = new DataConfigToRoleCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setRoleTypeId_SignificantTerms() {
        setRoleTypeId_SignificantTerms(null);
    }

    public void setRoleTypeId_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda) {
        setRoleTypeId_SignificantTerms("roleTypeId", opLambda, null);
    }

    public void setRoleTypeId_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        setRoleTypeId_SignificantTerms("roleTypeId", opLambda, aggsLambda);
    }

    public void setRoleTypeId_SignificantTerms(String name, ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        SignificantTermsBuilder builder = regSignificantTermsA(name, "roleTypeId");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            DataConfigToRoleCA ca = new DataConfigToRoleCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setRoleTypeId_IpRange() {
        setRoleTypeId_IpRange(null);
    }

    public void setRoleTypeId_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda) {
        setRoleTypeId_IpRange("roleTypeId", opLambda, null);
    }

    public void setRoleTypeId_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        setRoleTypeId_IpRange("roleTypeId", opLambda, aggsLambda);
    }

    public void setRoleTypeId_IpRange(String name, ConditionOptionCall<IPv4RangeBuilder> opLambda,
            OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        IPv4RangeBuilder builder = regIpRangeA(name, "roleTypeId");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            DataConfigToRoleCA ca = new DataConfigToRoleCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setRoleTypeId_Count() {
        setRoleTypeId_Count(null);
    }

    public void setRoleTypeId_Count(ConditionOptionCall<ValueCountBuilder> opLambda) {
        setRoleTypeId_Count("roleTypeId", opLambda);
    }

    public void setRoleTypeId_Count(String name, ConditionOptionCall<ValueCountBuilder> opLambda) {
        ValueCountBuilder builder = regCountA(name, "roleTypeId");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setRoleTypeId_Cardinality() {
        setRoleTypeId_Cardinality(null);
    }

    public void setRoleTypeId_Cardinality(ConditionOptionCall<CardinalityBuilder> opLambda) {
        setRoleTypeId_Cardinality("roleTypeId", opLambda);
    }

    public void setRoleTypeId_Cardinality(String name, ConditionOptionCall<CardinalityBuilder> opLambda) {
        CardinalityBuilder builder = regCardinalityA(name, "roleTypeId");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setRoleTypeId_Missing() {
        setRoleTypeId_Missing(null);
    }

    public void setRoleTypeId_Missing(ConditionOptionCall<MissingBuilder> opLambda) {
        setRoleTypeId_Missing("roleTypeId", opLambda, null);
    }

    public void setRoleTypeId_Missing(ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        setRoleTypeId_Missing("roleTypeId", opLambda, aggsLambda);
    }

    public void setRoleTypeId_Missing(String name, ConditionOptionCall<MissingBuilder> opLambda,
            OperatorCall<BsDataConfigToRoleCA> aggsLambda) {
        MissingBuilder builder = regMissingA(name, "roleTypeId");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            DataConfigToRoleCA ca = new DataConfigToRoleCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

}
