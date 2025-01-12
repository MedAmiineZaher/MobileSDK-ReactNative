package com.selligent;

import android.content.Intent;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.selligent.sdk.SMInAppMessage;
import com.selligent.sdk.SMManager;

class InAppMessageBroadcastEventDataParser implements BroadcastEventDataParser {
    @Override
    public WritableMap parse(Intent intent) {
        SMInAppMessage[] messages;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU)
        {
            messages = intent.getSerializableExtra(SMManager.BROADCAST_DATA_IN_APP_MESSAGES, SMInAppMessage[].class);
        }
        else
        {
            messages = (SMInAppMessage[])intent.getSerializableExtra(SMManager.BROADCAST_DATA_IN_APP_MESSAGES);
        }

        return wrap(messages);
    }

    public WritableMap wrap(SMInAppMessage[] messages)
    {
        final WritableMap resultingMap = new WritableNativeMap();

        final WritableArray messageArray = new WritableNativeArray();
        for (SMInAppMessage message : messages) {
            WritableMap messageMap = new WritableNativeMap();
            messageMap.putString("id", message.id);
            messageMap.putString("title", message.title);
            messageArray.pushMap(messageMap);
        }
        resultingMap.putArray("messages", messageArray);

        return resultingMap;
    }
}
