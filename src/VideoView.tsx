import {StyleSheet, Text, View} from 'react-native';
import React from 'react';
import VideoComponent from './modules/VideoComponent';

const VideoView = () => {
  return (
    <View style={styles.container}>
      <Text>VideoView</Text>
      <VideoComponent />
    </View>
  );
};

export default VideoView;

const styles = StyleSheet.create({
  container: {
    width: 300,
    height: 200,
    backgroundColor: 'red',
  },
});
