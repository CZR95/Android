
// Paste the following code inside "AndroidManifest.xml"
<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />

<application>
	....
	
	<receiver android:name=".MyBroadcastReceiver" // This is name must matched with the created class name
		android:exported="true">
			<intent-filter>
				<action android:name="android.intent.action.BOOT_COMPLETED"/>
			</intent-filter>
	</receiver>
</application>

// Create a new class file and padddste the following code
public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
			Intent intent1 = new Intent();
			intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent1.setClass(context, MainActivity.class);
			context.startActivity(intent1);
		}

	}
}
