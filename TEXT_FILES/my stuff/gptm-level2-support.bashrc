# Broadridge by defaults use H: as homedrive and it doesn't work when using VPN
export HOMEDRIVE=/C/
export HOMEPATH=Users/$USERNAME

export DEVELOPER_DIR="/C/developer"
export GIT_SOURCES="${DEVELOPER_DIR}/sources"
export TOOLS_DIR="${DEVELOPER_DIR}/tools"
export TOOLS_DOWNLOAD_DIR="${DEVELOPER_DIR}/download"

export JAVA_HOME="${TOOLS_DIR}/openjdk-8u232-b09"
export GROOVY_HOME="${TOOLS_DIR}/groovy-2.4.15"
export CF_CLI_BIN="${TOOLS_DIR}/cf-cli-6.53.0"
export JQ_BIN="${TOOLS_DIR}/jq-1.6"
export RELEASE_CHECKER_HOME="${GIT_SOURCES}/gptm-services/release-checker"
export RELEASE_CHECKER_SCRIPTS="${RELEASE_CHECKER_HOME}/scripts"
export SOURCE_ENVS="${RELEASE_CHECKER_HOME}/env-shell"

export PATH="$JAVA_HOME/bin:$GROOVY_HOME/bin:$CF_CLI_BIN:$JQ_BIN:$RELEASE_CHECKER_SCRIPTS:$PATH"

# Convert JSON files exported from Splunk into text files to easier view them
splunk_j2t() {
    json_file="$1"
    source_instance="$2"
    if [[ -n "$source_instance" ]]; then        
        dir_name="${json_file%.*}"
        mkdir -p $dir_name        
        IDX=0
        while [[ "$IDX" -lt "$source_instance" ]]; do
            text_file="$dir_name/${IDX}.txt"
            echo "Converting $json_file to $text_file"
            jq -r --arg IDX "$IDX" '.result | select(.source_instance == $IDX) | .msg' $json_file > $text_file
            IDX=$((IDX+1))
        done               
    else
        text_file="${json_file%.*}.txt"
        echo "Converting $json_file to $text_file"
        jq -r '.result.msg' $json_file > $text_file
    fi
}

export -f splunk_j2t
