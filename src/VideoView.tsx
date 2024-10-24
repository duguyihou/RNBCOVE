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
          url: 'url-from-js',
        }}
        credentials={{
          accountId: 'id-from-js',
          policyKey: 'key-from-js',
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
