package com.example.fragments;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;

import androidx.annotation.Nullable;

public class SettingsActivity extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new MainSettingsFragment()).commit();
    }

    private static void bindSummaryValue(Preference preference){
        preference.setOnPreferenceChangeListener(listener);
        listener.onPreferenceChange(preference,
                PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getString(preference.getKey(), ""));
    }

    public static class MainSettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
            bindSummaryValue(findPreference("key_name"));
            bindSummaryValue(findPreference("key_mail"));
            bindSummaryValue(findPreference("key_age"));
            bindSummaryValue(findPreference("key_region"));
            bindSummaryValue(findPreference("key_music"));
            bindSummaryValue(findPreference("key_activity"));


        }
    }

    private static Preference.OnPreferenceChangeListener listener = new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            String stringValue = newValue.toString();
            if (preference instanceof ListPreference){
                ListPreference listPreference = (ListPreference) preference;
                int index = listPreference.findIndexOfValue(stringValue);

                preference.setSummary(index > 0
                        ? listPreference.getEntries()[index]
                        : null);
            } else if (preference instanceof EditTextPreference){
                preference.setSummary(stringValue);
            }else if (preference instanceof RingtonePreference){
                if (TextUtils.isEmpty(stringValue)){
                    preference.setSummary("Silent");
                } else {
                    Ringtone ringtone = RingtoneManager.getRingtone(preference.getContext(),
                            Uri.parse(stringValue));
                    if (ringtone == null){
                        preference.setSummary("choose notification ringtone");
                    } else {
                        String name = ringtone.getTitle(preference.getContext());
                        preference.setSummary(name);
                    }
                }
            }
            return true;
        }
    };
}
