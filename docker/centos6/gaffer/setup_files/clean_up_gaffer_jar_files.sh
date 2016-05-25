#!/bin/bash

# Copyright 2016 Crown Copyright
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

########################################################################
#  Builds jar files based after changes to source code
#  
#######################################################################



# Directory where gaffer source code is cloned to. 
export INSTALL_DIR=/Gaffer_Source

# Directory where jar files generated by the maven build are transferred to
export TARGET_DIR=/data/Gaffer/Source

# Directory where jar files used to test examples are located
export TEST_DIR=/data/Gaffer/Test

# Directory where gaffer scripts are located
export SCRIPT_DIR=/data/Gaffer/Script

# Directory where accumulo dependency jar files are located

export JAR_FILE_DIR=/jar_files

# Directory where dependency jars for gaffer are located

export DEPENDENCIES_JAR_DIR=/data/Gaffer/jar_files


# Remove jar files generated  by  maven build
echo "Removing jar files generated by maven file"

cd /data/Gaffer

rm -f ${TARGET_DIR}/*.jar ${TARGET_DIR}/*.tar

#  Remove Gaffer example jar files

echo "Removing  Gaffer example jar files"


rm -f ${TEST_DIR}/*.jar ${TEST_DIR}/*.tar

# Remove accumulo dependency jar files

rm -f ${JAR_FILE_DIR}/*.tgz ${JAR_FILE_DIR}/*.jar

rm -f ${DEPENDENCIES_JAR_DIR}/*.jar  ${DEPENDENCIES_JAR_DIR}/*.tgz

echo "Script completed"