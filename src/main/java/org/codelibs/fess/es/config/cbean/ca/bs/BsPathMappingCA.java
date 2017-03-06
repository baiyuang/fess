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
import org.codelibs.fess.es.config.cbean.ca.PathMappingCA;
import org.codelibs.fess.es.config.cbean.cq.PathMappingCQ;
import org.codelibs.fess.es.config.cbean.cq.bs.BsPathMappingCQ;
import org.elasticsearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.global.GlobalBuilder;
import org.elasticsearch.search.aggregations.bucket.histogram.HistogramBuilder;
import org.elasticsearch.search.aggregations.bucket.missing.MissingBuilder;
import org.elasticsearch.search.aggregations.bucket.range.RangeBuilder;
import org.elasticsearch.search.aggregations.bucket.range.ipv4.IPv4RangeBuilder;
import org.elasticsearch.search.aggregations.bucket.sampler.SamplerAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.significant.SignificantTermsBuilder;
import org.elasticsearch.search.aggregations.bucket.terms.TermsBuilder;
import org.elasticsearch.search.aggregations.metrics.avg.AvgBuilder;
import org.elasticsearch.search.aggregations.metrics.cardinality.CardinalityBuilder;
import org.elasticsearch.search.aggregations.metrics.max.MaxBuilder;
import org.elasticsearch.search.aggregations.metrics.min.MinBuilder;
import org.elasticsearch.search.aggregations.metrics.percentiles.PercentileRanksBuilder;
import org.elasticsearch.search.aggregations.metrics.percentiles.PercentilesBuilder;
import org.elasticsearch.search.aggregations.metrics.scripted.ScriptedMetricBuilder;
import org.elasticsearch.search.aggregations.metrics.stats.StatsBuilder;
import org.elasticsearch.search.aggregations.metrics.stats.extended.ExtendedStatsBuilder;
import org.elasticsearch.search.aggregations.metrics.sum.SumBuilder;
import org.elasticsearch.search.aggregations.metrics.tophits.TopHitsBuilder;
import org.elasticsearch.search.aggregations.metrics.valuecount.ValueCountBuilder;

/**
 * @author ESFlute (using FreeGen)
 */
public abstract class BsPathMappingCA extends EsAbstractConditionAggregation {

    // ===================================================================================
    //                                                                     Aggregation Set
    //                                                                           =========

    public void filter(String name, EsAbstractConditionQuery.OperatorCall<BsPathMappingCQ> queryLambda,
            ConditionOptionCall<FilterAggregationBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        PathMappingCQ cq = new PathMappingCQ();
        if (queryLambda != null) {
            queryLambda.callback(cq);
        }
        FilterAggregationBuilder builder = regFilterA(name, cq.getQuery());
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void global(String name, ConditionOptionCall<GlobalBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        GlobalBuilder builder = regGlobalA(name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void sampler(String name, ConditionOptionCall<SamplerAggregationBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        SamplerAggregationBuilder builder = regSamplerA(name);
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
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

    // String createdBy

    public void setCreatedBy_Terms() {
        setCreatedBy_Terms(null);
    }

    public void setCreatedBy_Terms(ConditionOptionCall<TermsBuilder> opLambda) {
        setCreatedBy_Terms("createdBy", opLambda, null);
    }

    public void setCreatedBy_Terms(ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setCreatedBy_Terms("createdBy", opLambda, aggsLambda);
    }

    public void setCreatedBy_Terms(String name, ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        TermsBuilder builder = regTermsA(name, "createdBy");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setCreatedBy_SignificantTerms() {
        setCreatedBy_SignificantTerms(null);
    }

    public void setCreatedBy_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda) {
        setCreatedBy_SignificantTerms("createdBy", opLambda, null);
    }

    public void setCreatedBy_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsPathMappingCA> aggsLambda) {
        setCreatedBy_SignificantTerms("createdBy", opLambda, aggsLambda);
    }

    public void setCreatedBy_SignificantTerms(String name, ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsPathMappingCA> aggsLambda) {
        SignificantTermsBuilder builder = regSignificantTermsA(name, "createdBy");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setCreatedBy_IpRange() {
        setCreatedBy_IpRange(null);
    }

    public void setCreatedBy_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda) {
        setCreatedBy_IpRange("createdBy", opLambda, null);
    }

    public void setCreatedBy_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setCreatedBy_IpRange("createdBy", opLambda, aggsLambda);
    }

    public void setCreatedBy_IpRange(String name, ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        IPv4RangeBuilder builder = regIpRangeA(name, "createdBy");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setCreatedBy_Count() {
        setCreatedBy_Count(null);
    }

    public void setCreatedBy_Count(ConditionOptionCall<ValueCountBuilder> opLambda) {
        setCreatedBy_Count("createdBy", opLambda);
    }

    public void setCreatedBy_Count(String name, ConditionOptionCall<ValueCountBuilder> opLambda) {
        ValueCountBuilder builder = regCountA(name, "createdBy");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedBy_Cardinality() {
        setCreatedBy_Cardinality(null);
    }

    public void setCreatedBy_Cardinality(ConditionOptionCall<CardinalityBuilder> opLambda) {
        setCreatedBy_Cardinality("createdBy", opLambda);
    }

    public void setCreatedBy_Cardinality(String name, ConditionOptionCall<CardinalityBuilder> opLambda) {
        CardinalityBuilder builder = regCardinalityA(name, "createdBy");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedBy_Missing() {
        setCreatedBy_Missing(null);
    }

    public void setCreatedBy_Missing(ConditionOptionCall<MissingBuilder> opLambda) {
        setCreatedBy_Missing("createdBy", opLambda, null);
    }

    public void setCreatedBy_Missing(ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setCreatedBy_Missing("createdBy", opLambda, aggsLambda);
    }

    public void setCreatedBy_Missing(String name, ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        MissingBuilder builder = regMissingA(name, "createdBy");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    // Long createdTime
    public void setCreatedTime_Avg() {
        setCreatedTime_Avg(null);
    }

    public void setCreatedTime_Avg(ConditionOptionCall<AvgBuilder> opLambda) {
        setCreatedTime_Avg("createdTime", opLambda);
    }

    public void setCreatedTime_Avg(String name, ConditionOptionCall<AvgBuilder> opLambda) {
        AvgBuilder builder = regAvgA(name, "createdTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_Max() {
        setCreatedTime_Max(null);
    }

    public void setCreatedTime_Max(ConditionOptionCall<MaxBuilder> opLambda) {
        setCreatedTime_Max("createdTime", opLambda);
    }

    public void setCreatedTime_Max(String name, ConditionOptionCall<MaxBuilder> opLambda) {
        MaxBuilder builder = regMaxA(name, "createdTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_Min() {
        setCreatedTime_Min(null);
    }

    public void setCreatedTime_Min(ConditionOptionCall<MinBuilder> opLambda) {
        setCreatedTime_Min("createdTime", opLambda);
    }

    public void setCreatedTime_Min(String name, ConditionOptionCall<MinBuilder> opLambda) {
        MinBuilder builder = regMinA(name, "createdTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_Sum() {
        setCreatedTime_Sum(null);
    }

    public void setCreatedTime_Sum(ConditionOptionCall<SumBuilder> opLambda) {
        setCreatedTime_Sum("createdTime", opLambda);
    }

    public void setCreatedTime_Sum(String name, ConditionOptionCall<SumBuilder> opLambda) {
        SumBuilder builder = regSumA(name, "createdTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_ExtendedStats() {
        setCreatedTime_ExtendedStats(null);
    }

    public void setCreatedTime_ExtendedStats(ConditionOptionCall<ExtendedStatsBuilder> opLambda) {
        setCreatedTime_ExtendedStats("createdTime", opLambda);
    }

    public void setCreatedTime_ExtendedStats(String name, ConditionOptionCall<ExtendedStatsBuilder> opLambda) {
        ExtendedStatsBuilder builder = regExtendedStatsA(name, "createdTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_Stats() {
        setCreatedTime_Stats(null);
    }

    public void setCreatedTime_Stats(ConditionOptionCall<StatsBuilder> opLambda) {
        setCreatedTime_Stats("createdTime", opLambda);
    }

    public void setCreatedTime_Stats(String name, ConditionOptionCall<StatsBuilder> opLambda) {
        StatsBuilder builder = regStatsA(name, "createdTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_Percentiles() {
        setCreatedTime_Percentiles(null);
    }

    public void setCreatedTime_Percentiles(ConditionOptionCall<PercentilesBuilder> opLambda) {
        setCreatedTime_Percentiles("createdTime", opLambda);
    }

    public void setCreatedTime_Percentiles(String name, ConditionOptionCall<PercentilesBuilder> opLambda) {
        PercentilesBuilder builder = regPercentilesA(name, "createdTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_PercentileRanks() {
        setCreatedTime_PercentileRanks(null);
    }

    public void setCreatedTime_PercentileRanks(ConditionOptionCall<PercentileRanksBuilder> opLambda) {
        setCreatedTime_PercentileRanks("createdTime", opLambda);
    }

    public void setCreatedTime_PercentileRanks(String name, ConditionOptionCall<PercentileRanksBuilder> opLambda) {
        PercentileRanksBuilder builder = regPercentileRanksA(name, "createdTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_Histogram() {
        setCreatedTime_Histogram(null);
    }

    public void setCreatedTime_Histogram(ConditionOptionCall<HistogramBuilder> opLambda) {
        setCreatedTime_Histogram("createdTime", opLambda, null);
    }

    public void setCreatedTime_Histogram(ConditionOptionCall<HistogramBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setCreatedTime_Histogram("createdTime", opLambda, aggsLambda);
    }

    public void setCreatedTime_Histogram(String name, ConditionOptionCall<HistogramBuilder> opLambda,
            OperatorCall<BsPathMappingCA> aggsLambda) {
        HistogramBuilder builder = regHistogramA(name, "createdTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setCreatedTime_Range() {
        setCreatedTime_Range(null);
    }

    public void setCreatedTime_Range(ConditionOptionCall<RangeBuilder> opLambda) {
        setCreatedTime_Range("createdTime", opLambda, null);
    }

    public void setCreatedTime_Range(ConditionOptionCall<RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setCreatedTime_Range("createdTime", opLambda, aggsLambda);
    }

    public void setCreatedTime_Range(String name, ConditionOptionCall<RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        RangeBuilder builder = regRangeA(name, "createdTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setCreatedTime_Count() {
        setCreatedTime_Count(null);
    }

    public void setCreatedTime_Count(ConditionOptionCall<ValueCountBuilder> opLambda) {
        setCreatedTime_Count("createdTime", opLambda);
    }

    public void setCreatedTime_Count(String name, ConditionOptionCall<ValueCountBuilder> opLambda) {
        ValueCountBuilder builder = regCountA(name, "createdTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_Cardinality() {
        setCreatedTime_Cardinality(null);
    }

    public void setCreatedTime_Cardinality(ConditionOptionCall<CardinalityBuilder> opLambda) {
        setCreatedTime_Cardinality("createdTime", opLambda);
    }

    public void setCreatedTime_Cardinality(String name, ConditionOptionCall<CardinalityBuilder> opLambda) {
        CardinalityBuilder builder = regCardinalityA(name, "createdTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setCreatedTime_Missing() {
        setCreatedTime_Missing(null);
    }

    public void setCreatedTime_Missing(ConditionOptionCall<MissingBuilder> opLambda) {
        setCreatedTime_Missing("createdTime", opLambda, null);
    }

    public void setCreatedTime_Missing(ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setCreatedTime_Missing("createdTime", opLambda, aggsLambda);
    }

    public void setCreatedTime_Missing(String name, ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        MissingBuilder builder = regMissingA(name, "createdTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    // String processType

    public void setProcessType_Terms() {
        setProcessType_Terms(null);
    }

    public void setProcessType_Terms(ConditionOptionCall<TermsBuilder> opLambda) {
        setProcessType_Terms("processType", opLambda, null);
    }

    public void setProcessType_Terms(ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setProcessType_Terms("processType", opLambda, aggsLambda);
    }

    public void setProcessType_Terms(String name, ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        TermsBuilder builder = regTermsA(name, "processType");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setProcessType_SignificantTerms() {
        setProcessType_SignificantTerms(null);
    }

    public void setProcessType_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda) {
        setProcessType_SignificantTerms("processType", opLambda, null);
    }

    public void setProcessType_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsPathMappingCA> aggsLambda) {
        setProcessType_SignificantTerms("processType", opLambda, aggsLambda);
    }

    public void setProcessType_SignificantTerms(String name, ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsPathMappingCA> aggsLambda) {
        SignificantTermsBuilder builder = regSignificantTermsA(name, "processType");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setProcessType_IpRange() {
        setProcessType_IpRange(null);
    }

    public void setProcessType_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda) {
        setProcessType_IpRange("processType", opLambda, null);
    }

    public void setProcessType_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setProcessType_IpRange("processType", opLambda, aggsLambda);
    }

    public void setProcessType_IpRange(String name, ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        IPv4RangeBuilder builder = regIpRangeA(name, "processType");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setProcessType_Count() {
        setProcessType_Count(null);
    }

    public void setProcessType_Count(ConditionOptionCall<ValueCountBuilder> opLambda) {
        setProcessType_Count("processType", opLambda);
    }

    public void setProcessType_Count(String name, ConditionOptionCall<ValueCountBuilder> opLambda) {
        ValueCountBuilder builder = regCountA(name, "processType");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setProcessType_Cardinality() {
        setProcessType_Cardinality(null);
    }

    public void setProcessType_Cardinality(ConditionOptionCall<CardinalityBuilder> opLambda) {
        setProcessType_Cardinality("processType", opLambda);
    }

    public void setProcessType_Cardinality(String name, ConditionOptionCall<CardinalityBuilder> opLambda) {
        CardinalityBuilder builder = regCardinalityA(name, "processType");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setProcessType_Missing() {
        setProcessType_Missing(null);
    }

    public void setProcessType_Missing(ConditionOptionCall<MissingBuilder> opLambda) {
        setProcessType_Missing("processType", opLambda, null);
    }

    public void setProcessType_Missing(ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setProcessType_Missing("processType", opLambda, aggsLambda);
    }

    public void setProcessType_Missing(String name, ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        MissingBuilder builder = regMissingA(name, "processType");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    // String regex

    public void setRegex_Terms() {
        setRegex_Terms(null);
    }

    public void setRegex_Terms(ConditionOptionCall<TermsBuilder> opLambda) {
        setRegex_Terms("regex", opLambda, null);
    }

    public void setRegex_Terms(ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setRegex_Terms("regex", opLambda, aggsLambda);
    }

    public void setRegex_Terms(String name, ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        TermsBuilder builder = regTermsA(name, "regex");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setRegex_SignificantTerms() {
        setRegex_SignificantTerms(null);
    }

    public void setRegex_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda) {
        setRegex_SignificantTerms("regex", opLambda, null);
    }

    public void setRegex_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setRegex_SignificantTerms("regex", opLambda, aggsLambda);
    }

    public void setRegex_SignificantTerms(String name, ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsPathMappingCA> aggsLambda) {
        SignificantTermsBuilder builder = regSignificantTermsA(name, "regex");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setRegex_IpRange() {
        setRegex_IpRange(null);
    }

    public void setRegex_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda) {
        setRegex_IpRange("regex", opLambda, null);
    }

    public void setRegex_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setRegex_IpRange("regex", opLambda, aggsLambda);
    }

    public void setRegex_IpRange(String name, ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        IPv4RangeBuilder builder = regIpRangeA(name, "regex");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setRegex_Count() {
        setRegex_Count(null);
    }

    public void setRegex_Count(ConditionOptionCall<ValueCountBuilder> opLambda) {
        setRegex_Count("regex", opLambda);
    }

    public void setRegex_Count(String name, ConditionOptionCall<ValueCountBuilder> opLambda) {
        ValueCountBuilder builder = regCountA(name, "regex");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setRegex_Cardinality() {
        setRegex_Cardinality(null);
    }

    public void setRegex_Cardinality(ConditionOptionCall<CardinalityBuilder> opLambda) {
        setRegex_Cardinality("regex", opLambda);
    }

    public void setRegex_Cardinality(String name, ConditionOptionCall<CardinalityBuilder> opLambda) {
        CardinalityBuilder builder = regCardinalityA(name, "regex");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setRegex_Missing() {
        setRegex_Missing(null);
    }

    public void setRegex_Missing(ConditionOptionCall<MissingBuilder> opLambda) {
        setRegex_Missing("regex", opLambda, null);
    }

    public void setRegex_Missing(ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setRegex_Missing("regex", opLambda, aggsLambda);
    }

    public void setRegex_Missing(String name, ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        MissingBuilder builder = regMissingA(name, "regex");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    // String replacement

    public void setReplacement_Terms() {
        setReplacement_Terms(null);
    }

    public void setReplacement_Terms(ConditionOptionCall<TermsBuilder> opLambda) {
        setReplacement_Terms("replacement", opLambda, null);
    }

    public void setReplacement_Terms(ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setReplacement_Terms("replacement", opLambda, aggsLambda);
    }

    public void setReplacement_Terms(String name, ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        TermsBuilder builder = regTermsA(name, "replacement");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setReplacement_SignificantTerms() {
        setReplacement_SignificantTerms(null);
    }

    public void setReplacement_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda) {
        setReplacement_SignificantTerms("replacement", opLambda, null);
    }

    public void setReplacement_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsPathMappingCA> aggsLambda) {
        setReplacement_SignificantTerms("replacement", opLambda, aggsLambda);
    }

    public void setReplacement_SignificantTerms(String name, ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsPathMappingCA> aggsLambda) {
        SignificantTermsBuilder builder = regSignificantTermsA(name, "replacement");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setReplacement_IpRange() {
        setReplacement_IpRange(null);
    }

    public void setReplacement_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda) {
        setReplacement_IpRange("replacement", opLambda, null);
    }

    public void setReplacement_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setReplacement_IpRange("replacement", opLambda, aggsLambda);
    }

    public void setReplacement_IpRange(String name, ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        IPv4RangeBuilder builder = regIpRangeA(name, "replacement");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setReplacement_Count() {
        setReplacement_Count(null);
    }

    public void setReplacement_Count(ConditionOptionCall<ValueCountBuilder> opLambda) {
        setReplacement_Count("replacement", opLambda);
    }

    public void setReplacement_Count(String name, ConditionOptionCall<ValueCountBuilder> opLambda) {
        ValueCountBuilder builder = regCountA(name, "replacement");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setReplacement_Cardinality() {
        setReplacement_Cardinality(null);
    }

    public void setReplacement_Cardinality(ConditionOptionCall<CardinalityBuilder> opLambda) {
        setReplacement_Cardinality("replacement", opLambda);
    }

    public void setReplacement_Cardinality(String name, ConditionOptionCall<CardinalityBuilder> opLambda) {
        CardinalityBuilder builder = regCardinalityA(name, "replacement");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setReplacement_Missing() {
        setReplacement_Missing(null);
    }

    public void setReplacement_Missing(ConditionOptionCall<MissingBuilder> opLambda) {
        setReplacement_Missing("replacement", opLambda, null);
    }

    public void setReplacement_Missing(ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setReplacement_Missing("replacement", opLambda, aggsLambda);
    }

    public void setReplacement_Missing(String name, ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        MissingBuilder builder = regMissingA(name, "replacement");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    // Integer sortOrder
    public void setSortOrder_Avg() {
        setSortOrder_Avg(null);
    }

    public void setSortOrder_Avg(ConditionOptionCall<AvgBuilder> opLambda) {
        setSortOrder_Avg("sortOrder", opLambda);
    }

    public void setSortOrder_Avg(String name, ConditionOptionCall<AvgBuilder> opLambda) {
        AvgBuilder builder = regAvgA(name, "sortOrder");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_Max() {
        setSortOrder_Max(null);
    }

    public void setSortOrder_Max(ConditionOptionCall<MaxBuilder> opLambda) {
        setSortOrder_Max("sortOrder", opLambda);
    }

    public void setSortOrder_Max(String name, ConditionOptionCall<MaxBuilder> opLambda) {
        MaxBuilder builder = regMaxA(name, "sortOrder");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_Min() {
        setSortOrder_Min(null);
    }

    public void setSortOrder_Min(ConditionOptionCall<MinBuilder> opLambda) {
        setSortOrder_Min("sortOrder", opLambda);
    }

    public void setSortOrder_Min(String name, ConditionOptionCall<MinBuilder> opLambda) {
        MinBuilder builder = regMinA(name, "sortOrder");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_Sum() {
        setSortOrder_Sum(null);
    }

    public void setSortOrder_Sum(ConditionOptionCall<SumBuilder> opLambda) {
        setSortOrder_Sum("sortOrder", opLambda);
    }

    public void setSortOrder_Sum(String name, ConditionOptionCall<SumBuilder> opLambda) {
        SumBuilder builder = regSumA(name, "sortOrder");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_ExtendedStats() {
        setSortOrder_ExtendedStats(null);
    }

    public void setSortOrder_ExtendedStats(ConditionOptionCall<ExtendedStatsBuilder> opLambda) {
        setSortOrder_ExtendedStats("sortOrder", opLambda);
    }

    public void setSortOrder_ExtendedStats(String name, ConditionOptionCall<ExtendedStatsBuilder> opLambda) {
        ExtendedStatsBuilder builder = regExtendedStatsA(name, "sortOrder");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_Stats() {
        setSortOrder_Stats(null);
    }

    public void setSortOrder_Stats(ConditionOptionCall<StatsBuilder> opLambda) {
        setSortOrder_Stats("sortOrder", opLambda);
    }

    public void setSortOrder_Stats(String name, ConditionOptionCall<StatsBuilder> opLambda) {
        StatsBuilder builder = regStatsA(name, "sortOrder");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_Percentiles() {
        setSortOrder_Percentiles(null);
    }

    public void setSortOrder_Percentiles(ConditionOptionCall<PercentilesBuilder> opLambda) {
        setSortOrder_Percentiles("sortOrder", opLambda);
    }

    public void setSortOrder_Percentiles(String name, ConditionOptionCall<PercentilesBuilder> opLambda) {
        PercentilesBuilder builder = regPercentilesA(name, "sortOrder");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_PercentileRanks() {
        setSortOrder_PercentileRanks(null);
    }

    public void setSortOrder_PercentileRanks(ConditionOptionCall<PercentileRanksBuilder> opLambda) {
        setSortOrder_PercentileRanks("sortOrder", opLambda);
    }

    public void setSortOrder_PercentileRanks(String name, ConditionOptionCall<PercentileRanksBuilder> opLambda) {
        PercentileRanksBuilder builder = regPercentileRanksA(name, "sortOrder");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_Histogram() {
        setSortOrder_Histogram(null);
    }

    public void setSortOrder_Histogram(ConditionOptionCall<HistogramBuilder> opLambda) {
        setSortOrder_Histogram("sortOrder", opLambda, null);
    }

    public void setSortOrder_Histogram(ConditionOptionCall<HistogramBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setSortOrder_Histogram("sortOrder", opLambda, aggsLambda);
    }

    public void setSortOrder_Histogram(String name, ConditionOptionCall<HistogramBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        HistogramBuilder builder = regHistogramA(name, "sortOrder");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setSortOrder_Range() {
        setSortOrder_Range(null);
    }

    public void setSortOrder_Range(ConditionOptionCall<RangeBuilder> opLambda) {
        setSortOrder_Range("sortOrder", opLambda, null);
    }

    public void setSortOrder_Range(ConditionOptionCall<RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setSortOrder_Range("sortOrder", opLambda, aggsLambda);
    }

    public void setSortOrder_Range(String name, ConditionOptionCall<RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        RangeBuilder builder = regRangeA(name, "sortOrder");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setSortOrder_Count() {
        setSortOrder_Count(null);
    }

    public void setSortOrder_Count(ConditionOptionCall<ValueCountBuilder> opLambda) {
        setSortOrder_Count("sortOrder", opLambda);
    }

    public void setSortOrder_Count(String name, ConditionOptionCall<ValueCountBuilder> opLambda) {
        ValueCountBuilder builder = regCountA(name, "sortOrder");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_Cardinality() {
        setSortOrder_Cardinality(null);
    }

    public void setSortOrder_Cardinality(ConditionOptionCall<CardinalityBuilder> opLambda) {
        setSortOrder_Cardinality("sortOrder", opLambda);
    }

    public void setSortOrder_Cardinality(String name, ConditionOptionCall<CardinalityBuilder> opLambda) {
        CardinalityBuilder builder = regCardinalityA(name, "sortOrder");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setSortOrder_Missing() {
        setSortOrder_Missing(null);
    }

    public void setSortOrder_Missing(ConditionOptionCall<MissingBuilder> opLambda) {
        setSortOrder_Missing("sortOrder", opLambda, null);
    }

    public void setSortOrder_Missing(ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setSortOrder_Missing("sortOrder", opLambda, aggsLambda);
    }

    public void setSortOrder_Missing(String name, ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        MissingBuilder builder = regMissingA(name, "sortOrder");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    // String userAgent

    public void setUserAgent_Terms() {
        setUserAgent_Terms(null);
    }

    public void setUserAgent_Terms(ConditionOptionCall<TermsBuilder> opLambda) {
        setUserAgent_Terms("userAgent", opLambda, null);
    }

    public void setUserAgent_Terms(ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setUserAgent_Terms("userAgent", opLambda, aggsLambda);
    }

    public void setUserAgent_Terms(String name, ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        TermsBuilder builder = regTermsA(name, "userAgent");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setUserAgent_SignificantTerms() {
        setUserAgent_SignificantTerms(null);
    }

    public void setUserAgent_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda) {
        setUserAgent_SignificantTerms("userAgent", opLambda, null);
    }

    public void setUserAgent_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsPathMappingCA> aggsLambda) {
        setUserAgent_SignificantTerms("userAgent", opLambda, aggsLambda);
    }

    public void setUserAgent_SignificantTerms(String name, ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsPathMappingCA> aggsLambda) {
        SignificantTermsBuilder builder = regSignificantTermsA(name, "userAgent");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setUserAgent_IpRange() {
        setUserAgent_IpRange(null);
    }

    public void setUserAgent_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda) {
        setUserAgent_IpRange("userAgent", opLambda, null);
    }

    public void setUserAgent_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setUserAgent_IpRange("userAgent", opLambda, aggsLambda);
    }

    public void setUserAgent_IpRange(String name, ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        IPv4RangeBuilder builder = regIpRangeA(name, "userAgent");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setUserAgent_Count() {
        setUserAgent_Count(null);
    }

    public void setUserAgent_Count(ConditionOptionCall<ValueCountBuilder> opLambda) {
        setUserAgent_Count("userAgent", opLambda);
    }

    public void setUserAgent_Count(String name, ConditionOptionCall<ValueCountBuilder> opLambda) {
        ValueCountBuilder builder = regCountA(name, "userAgent");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUserAgent_Cardinality() {
        setUserAgent_Cardinality(null);
    }

    public void setUserAgent_Cardinality(ConditionOptionCall<CardinalityBuilder> opLambda) {
        setUserAgent_Cardinality("userAgent", opLambda);
    }

    public void setUserAgent_Cardinality(String name, ConditionOptionCall<CardinalityBuilder> opLambda) {
        CardinalityBuilder builder = regCardinalityA(name, "userAgent");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUserAgent_Missing() {
        setUserAgent_Missing(null);
    }

    public void setUserAgent_Missing(ConditionOptionCall<MissingBuilder> opLambda) {
        setUserAgent_Missing("userAgent", opLambda, null);
    }

    public void setUserAgent_Missing(ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setUserAgent_Missing("userAgent", opLambda, aggsLambda);
    }

    public void setUserAgent_Missing(String name, ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        MissingBuilder builder = regMissingA(name, "userAgent");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    // String updatedBy

    public void setUpdatedBy_Terms() {
        setUpdatedBy_Terms(null);
    }

    public void setUpdatedBy_Terms(ConditionOptionCall<TermsBuilder> opLambda) {
        setUpdatedBy_Terms("updatedBy", opLambda, null);
    }

    public void setUpdatedBy_Terms(ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setUpdatedBy_Terms("updatedBy", opLambda, aggsLambda);
    }

    public void setUpdatedBy_Terms(String name, ConditionOptionCall<TermsBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        TermsBuilder builder = regTermsA(name, "updatedBy");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setUpdatedBy_SignificantTerms() {
        setUpdatedBy_SignificantTerms(null);
    }

    public void setUpdatedBy_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda) {
        setUpdatedBy_SignificantTerms("updatedBy", opLambda, null);
    }

    public void setUpdatedBy_SignificantTerms(ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsPathMappingCA> aggsLambda) {
        setUpdatedBy_SignificantTerms("updatedBy", opLambda, aggsLambda);
    }

    public void setUpdatedBy_SignificantTerms(String name, ConditionOptionCall<SignificantTermsBuilder> opLambda,
            OperatorCall<BsPathMappingCA> aggsLambda) {
        SignificantTermsBuilder builder = regSignificantTermsA(name, "updatedBy");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setUpdatedBy_IpRange() {
        setUpdatedBy_IpRange(null);
    }

    public void setUpdatedBy_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda) {
        setUpdatedBy_IpRange("updatedBy", opLambda, null);
    }

    public void setUpdatedBy_IpRange(ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setUpdatedBy_IpRange("updatedBy", opLambda, aggsLambda);
    }

    public void setUpdatedBy_IpRange(String name, ConditionOptionCall<IPv4RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        IPv4RangeBuilder builder = regIpRangeA(name, "updatedBy");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setUpdatedBy_Count() {
        setUpdatedBy_Count(null);
    }

    public void setUpdatedBy_Count(ConditionOptionCall<ValueCountBuilder> opLambda) {
        setUpdatedBy_Count("updatedBy", opLambda);
    }

    public void setUpdatedBy_Count(String name, ConditionOptionCall<ValueCountBuilder> opLambda) {
        ValueCountBuilder builder = regCountA(name, "updatedBy");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedBy_Cardinality() {
        setUpdatedBy_Cardinality(null);
    }

    public void setUpdatedBy_Cardinality(ConditionOptionCall<CardinalityBuilder> opLambda) {
        setUpdatedBy_Cardinality("updatedBy", opLambda);
    }

    public void setUpdatedBy_Cardinality(String name, ConditionOptionCall<CardinalityBuilder> opLambda) {
        CardinalityBuilder builder = regCardinalityA(name, "updatedBy");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedBy_Missing() {
        setUpdatedBy_Missing(null);
    }

    public void setUpdatedBy_Missing(ConditionOptionCall<MissingBuilder> opLambda) {
        setUpdatedBy_Missing("updatedBy", opLambda, null);
    }

    public void setUpdatedBy_Missing(ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setUpdatedBy_Missing("updatedBy", opLambda, aggsLambda);
    }

    public void setUpdatedBy_Missing(String name, ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        MissingBuilder builder = regMissingA(name, "updatedBy");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    // Long updatedTime
    public void setUpdatedTime_Avg() {
        setUpdatedTime_Avg(null);
    }

    public void setUpdatedTime_Avg(ConditionOptionCall<AvgBuilder> opLambda) {
        setUpdatedTime_Avg("updatedTime", opLambda);
    }

    public void setUpdatedTime_Avg(String name, ConditionOptionCall<AvgBuilder> opLambda) {
        AvgBuilder builder = regAvgA(name, "updatedTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_Max() {
        setUpdatedTime_Max(null);
    }

    public void setUpdatedTime_Max(ConditionOptionCall<MaxBuilder> opLambda) {
        setUpdatedTime_Max("updatedTime", opLambda);
    }

    public void setUpdatedTime_Max(String name, ConditionOptionCall<MaxBuilder> opLambda) {
        MaxBuilder builder = regMaxA(name, "updatedTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_Min() {
        setUpdatedTime_Min(null);
    }

    public void setUpdatedTime_Min(ConditionOptionCall<MinBuilder> opLambda) {
        setUpdatedTime_Min("updatedTime", opLambda);
    }

    public void setUpdatedTime_Min(String name, ConditionOptionCall<MinBuilder> opLambda) {
        MinBuilder builder = regMinA(name, "updatedTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_Sum() {
        setUpdatedTime_Sum(null);
    }

    public void setUpdatedTime_Sum(ConditionOptionCall<SumBuilder> opLambda) {
        setUpdatedTime_Sum("updatedTime", opLambda);
    }

    public void setUpdatedTime_Sum(String name, ConditionOptionCall<SumBuilder> opLambda) {
        SumBuilder builder = regSumA(name, "updatedTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_ExtendedStats() {
        setUpdatedTime_ExtendedStats(null);
    }

    public void setUpdatedTime_ExtendedStats(ConditionOptionCall<ExtendedStatsBuilder> opLambda) {
        setUpdatedTime_ExtendedStats("updatedTime", opLambda);
    }

    public void setUpdatedTime_ExtendedStats(String name, ConditionOptionCall<ExtendedStatsBuilder> opLambda) {
        ExtendedStatsBuilder builder = regExtendedStatsA(name, "updatedTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_Stats() {
        setUpdatedTime_Stats(null);
    }

    public void setUpdatedTime_Stats(ConditionOptionCall<StatsBuilder> opLambda) {
        setUpdatedTime_Stats("updatedTime", opLambda);
    }

    public void setUpdatedTime_Stats(String name, ConditionOptionCall<StatsBuilder> opLambda) {
        StatsBuilder builder = regStatsA(name, "updatedTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_Percentiles() {
        setUpdatedTime_Percentiles(null);
    }

    public void setUpdatedTime_Percentiles(ConditionOptionCall<PercentilesBuilder> opLambda) {
        setUpdatedTime_Percentiles("updatedTime", opLambda);
    }

    public void setUpdatedTime_Percentiles(String name, ConditionOptionCall<PercentilesBuilder> opLambda) {
        PercentilesBuilder builder = regPercentilesA(name, "updatedTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_PercentileRanks() {
        setUpdatedTime_PercentileRanks(null);
    }

    public void setUpdatedTime_PercentileRanks(ConditionOptionCall<PercentileRanksBuilder> opLambda) {
        setUpdatedTime_PercentileRanks("updatedTime", opLambda);
    }

    public void setUpdatedTime_PercentileRanks(String name, ConditionOptionCall<PercentileRanksBuilder> opLambda) {
        PercentileRanksBuilder builder = regPercentileRanksA(name, "updatedTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_Histogram() {
        setUpdatedTime_Histogram(null);
    }

    public void setUpdatedTime_Histogram(ConditionOptionCall<HistogramBuilder> opLambda) {
        setUpdatedTime_Histogram("updatedTime", opLambda, null);
    }

    public void setUpdatedTime_Histogram(ConditionOptionCall<HistogramBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setUpdatedTime_Histogram("updatedTime", opLambda, aggsLambda);
    }

    public void setUpdatedTime_Histogram(String name, ConditionOptionCall<HistogramBuilder> opLambda,
            OperatorCall<BsPathMappingCA> aggsLambda) {
        HistogramBuilder builder = regHistogramA(name, "updatedTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setUpdatedTime_Range() {
        setUpdatedTime_Range(null);
    }

    public void setUpdatedTime_Range(ConditionOptionCall<RangeBuilder> opLambda) {
        setUpdatedTime_Range("updatedTime", opLambda, null);
    }

    public void setUpdatedTime_Range(ConditionOptionCall<RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setUpdatedTime_Range("updatedTime", opLambda, aggsLambda);
    }

    public void setUpdatedTime_Range(String name, ConditionOptionCall<RangeBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        RangeBuilder builder = regRangeA(name, "updatedTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

    public void setUpdatedTime_Count() {
        setUpdatedTime_Count(null);
    }

    public void setUpdatedTime_Count(ConditionOptionCall<ValueCountBuilder> opLambda) {
        setUpdatedTime_Count("updatedTime", opLambda);
    }

    public void setUpdatedTime_Count(String name, ConditionOptionCall<ValueCountBuilder> opLambda) {
        ValueCountBuilder builder = regCountA(name, "updatedTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_Cardinality() {
        setUpdatedTime_Cardinality(null);
    }

    public void setUpdatedTime_Cardinality(ConditionOptionCall<CardinalityBuilder> opLambda) {
        setUpdatedTime_Cardinality("updatedTime", opLambda);
    }

    public void setUpdatedTime_Cardinality(String name, ConditionOptionCall<CardinalityBuilder> opLambda) {
        CardinalityBuilder builder = regCardinalityA(name, "updatedTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
    }

    public void setUpdatedTime_Missing() {
        setUpdatedTime_Missing(null);
    }

    public void setUpdatedTime_Missing(ConditionOptionCall<MissingBuilder> opLambda) {
        setUpdatedTime_Missing("updatedTime", opLambda, null);
    }

    public void setUpdatedTime_Missing(ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        setUpdatedTime_Missing("updatedTime", opLambda, aggsLambda);
    }

    public void setUpdatedTime_Missing(String name, ConditionOptionCall<MissingBuilder> opLambda, OperatorCall<BsPathMappingCA> aggsLambda) {
        MissingBuilder builder = regMissingA(name, "updatedTime");
        if (opLambda != null) {
            opLambda.callback(builder);
        }
        if (aggsLambda != null) {
            PathMappingCA ca = new PathMappingCA();
            aggsLambda.callback(ca);
            ca.getAggregationBuilderList().forEach(builder::subAggregation);
        }
    }

}
