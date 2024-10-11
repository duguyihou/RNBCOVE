import {StyleSheet, Text, View} from 'react-native';
import React from 'react';
import VideoComponent from './modules/VideoComponent';

const VideoView = () => {
  return (
    <View>
      <Text>VideoView</Text>
      <VideoComponent
        style={styles.video}
        source={{
          url: 'https://avtshare01.rz.tu-ilmenau.de/avt-vqdb-uhd-1/test_1/segments/bigbuck_bunny_8bit_15000kbps_1080p_60.0fps_h264.mp4',
        }}
        credentials={{
          accountId: '5420904993001',
          policyKey:
            'BCpkADawqM3DwCTPGyMMiG0loem8lXox3utO1lFEP1i-_l1MpjRSVXMTSsa2ToslC129_W6YzwJpXbpbIVRFwf35qYM0pxo2HJK-_SotgmgrkmJTQ-024GkXIelVSY8LOHZzRBtcBU57M6Is',
        }}
      />
    </View>
  );
};

export default VideoView;

const styles = StyleSheet.create({
  video: {
    width: '100%',
    height: 300,
    backgroundColor: 'blue',
  },
});
