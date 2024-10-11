import React from 'react';
import {requireNativeComponent, StyleProp, ViewStyle} from 'react-native';
import {Credentials, Source} from './types';

const ComponentName = 'VideoView';

type Props = {
  source: Source;
  credentials: Credentials;
  style: StyleProp<ViewStyle>;
};
const NativeVideo = requireNativeComponent<Props>(ComponentName);

const VideoComponent = (props: Props) => {
  const {source, credentials, style} = props;
  return (
    <NativeVideo style={style} source={source} credentials={credentials} />
  );
};

export default VideoComponent;
