package com.twitter.finatra.json.internal.serde

import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.joda.cfg.FormatConfig
import com.twitter.finatra.json.internal.caseclass.wrapped.WrappedValueSerializer
import com.twitter.{util => ctu}
import org.joda.time.DateTime

private[finatra] object SerDeSimpleModule extends SimpleModule {
  addSerializer(WrappedValueSerializer)
  addSerializer(JodaDurationMillisSerializer)
  addSerializer(DurationStringSerializer)
  addSerializer(TimeStringSerializer)
  addDeserializer(
    classOf[DateTime],
    new JodaDatetimeDeserializer(FormatConfig.DEFAULT_DATETIME_PARSER))
  addDeserializer(classOf[ctu.Duration], DurationStringDeserializer)
}
