/*
 * Copyright 2016 Crown Copyright
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
package uk.gov.gchq.gaffer.function.filter;

import org.junit.Test;
import uk.gov.gchq.gaffer.commonutil.JsonUtil;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.function.FilterFunctionTest;
import uk.gov.gchq.gaffer.jsonserialisation.JSONSerialiser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class ExistsTest extends FilterFunctionTest {
    @Test
    public void shouldAcceptTheValueWhenNotNull() {
        // Given
        final Exists filter = new Exists();

        // When
        boolean accepted = filter.isValid("Not null value");

        // Then
        assertTrue(accepted);
    }

    @Test
    public void shouldRejectTheValueWhenNull() {
        // Given
        final Exists filter = new Exists();

        // When
        boolean accepted = filter.isValid((Object) null);

        // Then
        assertFalse(accepted);
    }

    @Test
    public void shouldClone() {
        // Given
        final Exists filter = new Exists();

        // When
        final Exists clonedFilter = filter.statelessClone();

        // Then
        assertNotSame(filter, clonedFilter);
    }

    @Test
    public void shouldJsonSerialiseAndDeserialise() throws SerialisationException {
        // Given
        final Exists filter = new Exists();

        // When
        final String json = new String(new JSONSerialiser().serialise(filter, true));

        // Then
        JsonUtil.assertEquals(String.format("{%n" +
                "  \"class\" : \"uk.gov.gchq.gaffer.function.filter.Exists\"%n" +
                "}"), json);

        // When 2
        final Exists deserialisedFilter = new JSONSerialiser().deserialise(json.getBytes(), Exists.class);

        // Then 2
        assertNotNull(deserialisedFilter);
    }

    @Override
    protected Class<Exists> getFunctionClass() {
        return Exists.class;
    }

    @Override
    protected Exists getInstance() {
        return new Exists();
    }
}
