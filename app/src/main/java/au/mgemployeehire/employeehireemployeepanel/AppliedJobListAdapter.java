package au.mgemployeehire.employeehireemployeepanel;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AppliedJobListAdapter extends ArrayAdapter<AppliedJobAdvertisementData> {

    private Activity context;
    private List<AppliedJobAdvertisementData> appliedJobList;

    public AppliedJobListAdapter(Activity context, List<AppliedJobAdvertisementData> appliedJobList) {
        super(context, R.layout.job_adv_list_view, appliedJobList);
        this.context = context;
        this.appliedJobList = appliedJobList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.job_adv_list_view, null, true);

        AppliedJobAdvertisementData appliedJobAdvertisementData = appliedJobList.get(position);

        TextView companyName = view.findViewById(R.id.companyNameID);
        TextView vacancy = view.findViewById(R.id.vacancyID);
        TextView jobPosition = view.findViewById(R.id.jobPositionID);
        TextView keyStr = view.findViewById(R.id.getKeyStrID);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConstant.appliedJobKeyStr = appliedJobAdvertisementData.getKeyStr();
                //Log.e("keyStr",""+jobAdvertisementData.getKeyStr());
                Intent intent = new Intent(context, JobDetailsOfAppliedJobsActivity.class);
                context.startActivity(intent);
            }
        });

        companyName.setText(appliedJobAdvertisementData.getCompanyNameStr());
        vacancy.setText(appliedJobAdvertisementData.getWorkerQuantityStr());
        jobPosition.setText(appliedJobAdvertisementData.getJobPositionStr());
        keyStr.setText(appliedJobAdvertisementData.getKeyStr());

        return view;
    }
}
