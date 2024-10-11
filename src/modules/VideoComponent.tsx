import React from 'react';
import {requireNativeComponent} from 'react-native';

const ComponentName = 'VideoView';

const NativeVideo = requireNativeComponent(ComponentName);

const VideoComponent = () => {
  return <NativeVideo />;
};

export default VideoComponent;
