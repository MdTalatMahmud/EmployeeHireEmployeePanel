package au.mgemployeehire.employeehireemployeepanel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class JobListAdapter extends ArrayAdapter<JobAdvertisementData> {

    private Activity context;
    private List<JobAdvertisementData> jobAdvertisementList;

    public JobListAdapter(Activity context, List<JobAdvertisementData> jobAdvertisementList) {
        super(context, R.layout.job_adv_list_view, jobAdvertisementList);
        this.context = context;
        this.jobAdvertisementList = jobAdvertisementList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.job_adv_list_view, null, true);

        JobAdvertisementData jobAdvertisementData = jobAdvertisementList.get(position);

        TextView companyName = view.findViewById(R.id.companyNameID);
        TextView vacancy = view.findViewById(R.id.vacancyID);
        TextView jobPosition = view.findViewById(R.id.jobPositionID);
        TextView keyStr = view.findViewById(R.id.getKeyStrID);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppConstant.keyStr = jobAdvertisementData.getKeyStr();
                Log.e("keyStr",""+jobAdvertisementData.getKeyStr());
                Intent intent = new Intent(context, JobDetailsActivity.class);
                context.startActivity(intent);
            }
        });

        companyName.setText(jobAdvertisementData.getCompanyNameStr());
        vacancy.setText(jobAdvertisementData.getWorkerQuantityStr());
        jobPosition.setText(jobAdvertisementData.getJobPositionStr());
        keyStr.setText(jobAdvertisementData.getKeyStr());

        return view;
    }
}
