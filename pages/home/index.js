import React from 'react'
import {View, Text, ScrollView} from 'react-native'

export default function Home() {
    return (
        <View>
            <View style={styles.header}/>
            <ScrollView>
                <View>
                    <Text>Hello Home Page</Text>
                </View>
            </ScrollView>
        </View>
    )
}

const styles = {
    header:{
        height: 56,
        width: '100%',
        backgroundColor: '#000'
    }
}