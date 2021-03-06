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

package uk.gov.gchq.gaffer.serialisation;

import uk.gov.gchq.gaffer.exception.SerialisationException;
import java.io.Serializable;

/**
 * Definition of what is required from a serialisation mechanism used by the Graph Store.
 * <p>
 * As a minimum, any Serialisation mechanism must be able to serialise and deserialise any given Property.
 */
public interface Serialisation<T> extends Serializable {

    /**
     * Enables checking whether the serialiser can serialise a particular class.
     *
     * @param clazz the object class to serialise
     * @return boolean true if it can be handled
     */
    boolean canHandle(final Class clazz);

    /**
     * Request that the Serialisation serialises some object and returns the raw bytes of the serialised form.
     *
     * @param object the object to be serialised
     * @return byte[] the serialised bytes
     * @throws SerialisationException if the object fails to serialise
     */
    byte[] serialise(final T object) throws SerialisationException;

    /**
     * From a byte array representing the Serialised form of a Property we should reconstruct the Object.
     *
     * @param bytes the serialised bytes to deserialise
     * @return T the deserialised object
     * @throws SerialisationException if the object fails to deserialise
     */
    T deserialise(final byte[] bytes) throws SerialisationException;

    /**
     * Handle an incoming null value and generate an appropriate byte array representation.
     *
     * @return byte[] the serialised bytes
     */
    byte[] serialiseNull();

    /**
     * Handle an empty byte array and reconstruct an appropriate representation in Object form.
     *
     * @return T the deserialised object
     * @throws SerialisationException if the object fails to deserialise
     */
    T deserialiseEmptyBytes() throws SerialisationException;

    /**
     * @return true if the serialisation will preserve the order of bytes, otherwise false.
     */
    boolean isByteOrderPreserved();

}
