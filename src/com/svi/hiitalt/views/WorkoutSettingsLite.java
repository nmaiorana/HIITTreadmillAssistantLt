/*
 * Copyright (C) 2010 Silent Viper Investments
 */

package com.svi.hiitalt.views;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

import com.svi.hiitalt.R;

public class WorkoutSettingsLite extends com.svi.hiit.views.WorkoutSettings {
	
	/**
	 * Don't allow music integration
	 */
	@Override
	protected void configurePlaylistSelection(SharedPreferences myPreferences) {
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		showUnlicensed();
	}
	
	/**
	 * No license check require for lite version
	 */
	@Override
	protected void doCheck() {
	}
	
	/**
	 * No license check require for lite version
	 */
	@Override
	protected void checkLicense() {
	}
	
	/**
	 * Allow to use lite version of application
	 */
	@Override
	protected void showUnlicensed() {
		Builder licenseNotifier = new Builder(this);
		licenseNotifier.setTitle(getText(R.string.app_name)+ " " + getText(R.string.lite_dialog_title));
		licenseNotifier.setMessage(R.string.lite_dialog_body);
		licenseNotifier.setPositiveButton(R.string.buy_button, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
                Intent marketIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                        "http://market.android.com/details?id=" + "com.svi.hiita"));
                    startActivity(marketIntent);
			}

		});
		licenseNotifier.setNegativeButton(R.string.no_thanks_button, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
			}
		});
		licenseNotifier.show();
	}


}
