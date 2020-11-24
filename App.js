import * as React from 'react';
import { ActivityIndicator, Platform, StyleSheet, Text, View } from 'react-native';
import importLazy from "./pages/base";


export default function App() {
  const [Home, setHomeMod] = React.useState(null)
  React.useEffect(() => {
    importLazy("pages/home/index.js").then(module => {
      setHomeMod(()=>module.default)
    })
  }, []);
  if (Home == null) {
    return <View>
      <ActivityIndicator size={50}/>
      <Text>Loading chunk</Text>
    </View>
  }
  return (
    <View style={styles.container}>
      <Home/>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});
