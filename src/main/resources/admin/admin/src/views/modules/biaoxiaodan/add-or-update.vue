<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}">
            <el-row>
                <el-col :span="12"  v-if="(sessionTable =='yonghu' && type=='info') || role == '管理员' ">
                    <el-form-item class="select" v-if="type!='info'"  label="财会审核人员" prop="caikuaiId">
                        <el-select v-model="ruleForm.caikuaiId" :disabled="ro.caikuaiId" filterable placeholder="请选择财会审核人员" @change="caikuaiChange">
                            <el-option
                                    v-for="(item,index) in caikuaiOptions"
                                    v-bind:key="item.id"
                                    :label="item.caikuaiName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="(sessionTable =='yonghu' && type=='info') || role == '管理员' ">
                    <el-form-item class="input" v-if="type!='info'"  label="财会审核人员姓名" prop="caikuaiName">
                        <el-input v-model="caikuaiForm.caikuaiName"
                                  placeholder="财会审核人员姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="财会审核人员姓名" prop="caikuaiName">
                            <el-input v-model="ruleForm.caikuaiName"
                                      placeholder="财会审核人员姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="(sessionTable =='yonghu' && type=='info') || role == '管理员' ">
                    <el-form-item class="input" v-if="type!='info'"  label="财会审核人员手机号" prop="caikuaiPhone">
                        <el-input v-model="caikuaiForm.caikuaiPhone"
                                  placeholder="财会审核人员手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="财会审核人员手机号" prop="caikuaiPhone">
                            <el-input v-model="ruleForm.caikuaiPhone"
                                      placeholder="财会审核人员手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="(sessionTable =='yonghu' && type=='info') || role == '管理员' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.caikuaiPhoto" label="财会审核人员头像" prop="caikuaiPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (caikuaiForm.caikuaiPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.caikuaiPhoto" label="财会审核人员头像" prop="caikuaiPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.caikuaiPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu'">
                    <el-form-item class="select" v-if="type!='info'"  label="用户" prop="yonghuId">
                        <el-select v-model="ruleForm.yonghuId" :disabled="ro.yonghuId" filterable placeholder="请选择用户" @change="yonghuChange">
                            <el-option
                                    v-for="(item,index) in yonghuOptions"
                                    v-bind:key="item.id"
                                    :label="item.yonghuName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuName">
                        <el-input v-model="yonghuForm.yonghuName"
                                  placeholder="用户姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="用户姓名" prop="yonghuName">
                            <el-input v-model="ruleForm.yonghuName"
                                      placeholder="用户姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='yonghu' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户手机号" prop="yonghuPhone">
                        <el-input v-model="yonghuForm.yonghuPhone"
                                  placeholder="用户手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="用户手机号" prop="yonghuPhone">
                            <el-input v-model="ruleForm.yonghuPhone"
                                      placeholder="用户手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='yonghu' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (yonghuForm.yonghuPhoto || '').split(',')" :src="item" width="100" height="100">
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.yonghuPhoto" label="用户头像" prop="yonghuPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.yonghuPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="yonghuId" name="yonghuId" type="hidden">
            <input id="caikuaiId" name="caikuaiId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="报销单编号" prop="biaoxiaodanUuidNumber">
                       <el-input v-model="ruleForm.biaoxiaodanUuidNumber"
                                 placeholder="报销单编号" clearable  :readonly="ro.biaoxiaodanUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="报销单编号" prop="biaoxiaodanUuidNumber">
                           <el-input v-model="ruleForm.biaoxiaodanUuidNumber"
                                     placeholder="报销单编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="报销单名称" prop="biaoxiaodanName">
                       <el-input v-model="ruleForm.biaoxiaodanName"
                                 placeholder="报销单名称" clearable  :readonly="ro.biaoxiaodanName"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="报销单名称" prop="biaoxiaodanName">
                           <el-input v-model="ruleForm.biaoxiaodanName"
                                     placeholder="报销单名称" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="报销人姓名" prop="biaoxiaodanBaoxiaorenName">
                       <el-input v-model="ruleForm.biaoxiaodanBaoxiaorenName"
                                 placeholder="报销人姓名" clearable  :readonly="ro.biaoxiaodanBaoxiaorenName"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="报销人姓名" prop="biaoxiaodanBaoxiaorenName">
                           <el-input v-model="ruleForm.biaoxiaodanBaoxiaorenName"
                                     placeholder="报销人姓名" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.biaoxiaodanBaoxiaorenPhoto" label="报销人头像照片" prop="biaoxiaodanBaoxiaorenPhoto">
                        <file-upload
                            tip="点击上传报销人头像照片"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.biaoxiaodanBaoxiaorenPhoto?ruleForm.biaoxiaodanBaoxiaorenPhoto:''"
                            @change="biaoxiaodanBaoxiaorenPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.biaoxiaodanBaoxiaorenPhoto" label="报销人头像照片" prop="biaoxiaodanBaoxiaorenPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.biaoxiaodanBaoxiaorenPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.biaoxiaodanBaoxiaorenShenfenzhengzPhoto" label="身份证正面" prop="biaoxiaodanBaoxiaorenShenfenzhengzPhoto">
                        <file-upload
                            tip="点击上传身份证正面"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.biaoxiaodanBaoxiaorenShenfenzhengzPhoto?ruleForm.biaoxiaodanBaoxiaorenShenfenzhengzPhoto:''"
                            @change="biaoxiaodanBaoxiaorenShenfenzhengzPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.biaoxiaodanBaoxiaorenShenfenzhengzPhoto" label="身份证正面" prop="biaoxiaodanBaoxiaorenShenfenzhengzPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.biaoxiaodanBaoxiaorenShenfenzhengzPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.biaoxiaodanBaoxiaorenShenfenzhengfPhoto" label="身份证反面" prop="biaoxiaodanBaoxiaorenShenfenzhengfPhoto">
                        <file-upload
                            tip="点击上传身份证反面"
                            action="file/upload"
                            :limit="3"
                            :multiple="true"
                            :fileUrls="ruleForm.biaoxiaodanBaoxiaorenShenfenzhengfPhoto?ruleForm.biaoxiaodanBaoxiaorenShenfenzhengfPhoto:''"
                            @change="biaoxiaodanBaoxiaorenShenfenzhengfPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.biaoxiaodanBaoxiaorenShenfenzhengfPhoto" label="身份证反面" prop="biaoxiaodanBaoxiaorenShenfenzhengfPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.biaoxiaodanBaoxiaorenShenfenzhengfPhoto || '').split(',')" :src="item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="报销人联系方式" prop="biaoxiaodanBaoxiaorenPhone">
                       <el-input v-model="ruleForm.biaoxiaodanBaoxiaorenPhone"
                                 placeholder="报销人联系方式" clearable  :readonly="ro.biaoxiaodanBaoxiaorenPhone"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="报销人联系方式" prop="biaoxiaodanBaoxiaorenPhone">
                           <el-input v-model="ruleForm.biaoxiaodanBaoxiaorenPhone"
                                     placeholder="报销人联系方式" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="报销人身份证号" prop="biaoxiaodanBaoxiaorenIdNumber">
                       <el-input v-model="ruleForm.biaoxiaodanBaoxiaorenIdNumber"
                                 placeholder="报销人身份证号" clearable  :readonly="ro.biaoxiaodanBaoxiaorenIdNumber"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="报销人身份证号" prop="biaoxiaodanBaoxiaorenIdNumber">
                           <el-input v-model="ruleForm.biaoxiaodanBaoxiaorenIdNumber"
                                     placeholder="报销人身份证号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="人员状态" prop="biaoxiaodanRenyuanTypes">
                        <el-select v-model="ruleForm.biaoxiaodanRenyuanTypes" :disabled="ro.biaoxiaodanRenyuanTypes" placeholder="请选择人员状态">
                            <el-option
                                v-for="(item,index) in biaoxiaodanRenyuanTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="人员状态" prop="biaoxiaodanRenyuanValue">
                        <el-input v-model="ruleForm.biaoxiaodanRenyuanValue"
                            placeholder="人员状态" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="病情" prop="biaoxiaodanBingqingTypes">
                        <el-select v-model="ruleForm.biaoxiaodanBingqingTypes" :disabled="ro.biaoxiaodanBingqingTypes" placeholder="请选择病情">
                            <el-option
                                v-for="(item,index) in biaoxiaodanBingqingTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="病情" prop="biaoxiaodanBingqingValue">
                        <el-input v-model="ruleForm.biaoxiaodanBingqingValue"
                            placeholder="病情" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="费用类型" prop="biaoxiaodanYiliaofeiyongTypes">
                        <el-select v-model="ruleForm.biaoxiaodanYiliaofeiyongTypes" :disabled="ro.biaoxiaodanYiliaofeiyongTypes" placeholder="请选择费用类型">
                            <el-option
                                v-for="(item,index) in biaoxiaodanYiliaofeiyongTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="费用类型" prop="biaoxiaodanYiliaofeiyongValue">
                        <el-input v-model="ruleForm.biaoxiaodanYiliaofeiyongValue"
                            placeholder="费用类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="报销金额" prop="biaoxiaodanNewJine">
                       <el-input v-model="ruleForm.biaoxiaodanNewJine"
                                 placeholder="报销金额" clearable  :readonly="ro.biaoxiaodanNewJine"></el-input>
                   </el-form-item>
                   <div v-else>
                       <el-form-item class="input" label="报销金额" prop="biaoxiaodanNewJine">
                           <el-input v-model="ruleForm.biaoxiaodanNewJine"
                                     placeholder="报销金额" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="upload" v-if="type!='info' && !ro.biaoxiaodanFile" label="相关报销凭证" prop="biaoxiaodanFile">
                        <file-upload
                                tip="点击上传相关报销凭证"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.biaoxiaodanFile?ruleForm.biaoxiaodanFile:''"
                                @change="biaoxiaodanFileUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.biaoxiaodanFile" label="相关报销凭证" prop="biaoxiaodanFile">
                            <a type="text" style="text-decoration:none" class="el-button" :href="ruleForm.biaoxiaodanFile"  >相关报销凭证下载</a>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="其他备注" prop="biaoxiaodanContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.biaoxiaodanContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.biaoxiaodanContent" label="其他备注" prop="biaoxiaodanContent">
                            <span v-html="ruleForm.biaoxiaodanContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.biaoxiaodanYesnoTypes" label="审核状态" prop="biaoxiaodanYesnoTypes">
                        <el-input v-model="ruleForm.biaoxiaodanYesnoValue" placeholder="审核状态" readonly></el-input>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.biaoxiaodanYesnoText" label="审核意见" prop="biaoxiaodanYesnoText">
                        <span v-html="ruleForm.biaoxiaodanYesnoText"></span>
                    </el-form-item>
                </div>
            </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                caikuaiForm: {},
                yonghuForm: {},
                ro:{
                    yonghuId: false,
                    caikuaiId: false,
                    biaoxiaodanUuidNumber: false,
                    biaoxiaodanName: false,
                    biaoxiaodanBaoxiaorenName: false,
                    biaoxiaodanBaoxiaorenPhoto: false,
                    biaoxiaodanBaoxiaorenShenfenzhengzPhoto: false,
                    biaoxiaodanBaoxiaorenShenfenzhengfPhoto: false,
                    biaoxiaodanBaoxiaorenPhone: false,
                    biaoxiaodanBaoxiaorenIdNumber: false,
                    biaoxiaodanRenyuanTypes: false,
                    biaoxiaodanBingqingTypes: false,
                    biaoxiaodanYiliaofeiyongTypes: false,
                    biaoxiaodanNewJine: false,
                    biaoxiaodanFile: false,
                    biaoxiaodanContent: false,
                    insertTime: false,
                    biaoxiaodanYesnoTypes: false,
                    biaoxiaodanYesnoText: false,
                },
                ruleForm: {
                    yonghuId: '',
                    caikuaiId: '',
                    biaoxiaodanUuidNumber: new Date().getTime(),
                    biaoxiaodanName: '',
                    biaoxiaodanBaoxiaorenName: '',
                    biaoxiaodanBaoxiaorenPhoto: '',
                    biaoxiaodanBaoxiaorenShenfenzhengzPhoto: '',
                    biaoxiaodanBaoxiaorenShenfenzhengfPhoto: '',
                    biaoxiaodanBaoxiaorenPhone: '',
                    biaoxiaodanBaoxiaorenIdNumber: '',
                    biaoxiaodanRenyuanTypes: '',
                    biaoxiaodanBingqingTypes: '',
                    biaoxiaodanYiliaofeiyongTypes: '',
                    biaoxiaodanNewJine: '',
                    biaoxiaodanFile: '',
                    biaoxiaodanContent: '',
                    insertTime: '',
                    biaoxiaodanYesnoTypes: '',
                    biaoxiaodanYesnoText: '',
                },
                biaoxiaodanRenyuanTypesOptions : [],
                biaoxiaodanBingqingTypesOptions : [],
                biaoxiaodanYiliaofeiyongTypesOptions : [],
                biaoxiaodanYesnoTypesOptions : [],
                caikuaiOptions : [],
                yonghuOptions : [],
                rules: {
                   yonghuId: [
                              { required: true, message: '用户不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   caikuaiId: [
                              { required: true, message: '财会审核人员不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   biaoxiaodanUuidNumber: [
                              { required: true, message: '报销单编号不能为空', trigger: 'blur' },
                          ],
                   biaoxiaodanName: [
                              { required: true, message: '报销单名称不能为空', trigger: 'blur' },
                          ],
                   biaoxiaodanBaoxiaorenName: [
                              { required: true, message: '报销人姓名不能为空', trigger: 'blur' },
                          ],
                   biaoxiaodanBaoxiaorenPhoto: [
                              { required: true, message: '报销人头像照片不能为空', trigger: 'blur' },
                          ],
                   biaoxiaodanBaoxiaorenShenfenzhengzPhoto: [
                              { required: true, message: '身份证正面不能为空', trigger: 'blur' },
                          ],
                   biaoxiaodanBaoxiaorenShenfenzhengfPhoto: [
                              { required: true, message: '身份证反面不能为空', trigger: 'blur' },
                          ],
                   biaoxiaodanBaoxiaorenPhone: [
                              { required: true, message: '报销人联系方式不能为空', trigger: 'blur' },
                          ],
                   biaoxiaodanBaoxiaorenIdNumber: [
                              { required: true, message: '报销人身份证号不能为空', trigger: 'blur' },
                          ],
                   biaoxiaodanRenyuanTypes: [
                              { required: true, message: '人员状态不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   biaoxiaodanBingqingTypes: [
                              { required: true, message: '病情不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   biaoxiaodanYiliaofeiyongTypes: [
                              { required: true, message: '费用类型不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   biaoxiaodanNewJine: [
                              { required: true, message: '报销金额不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]{0,6}(\.[0-9]{1,2})?$/,
                                  message: '只允许输入整数6位,小数2位的数字',
                                  trigger: 'blur'
                              }
                          ],
                   biaoxiaodanFile: [
                              { required: true, message: '相关报销凭证不能为空', trigger: 'blur' },
                          ],
                   biaoxiaodanContent: [
                              { required: true, message: '其他备注不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '申请时间不能为空', trigger: 'blur' },
                          ],
                   biaoxiaodanYesnoTypes: [
                              { required: true, message: '审核状态不能为空', trigger: 'blur' },
                              {  pattern: /^[1-9][0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   biaoxiaodanYesnoText: [
                              { required: true, message: '审核意见不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=biaoxiaodan_renyuan_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.biaoxiaodanRenyuanTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=biaoxiaodan_bingqing_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.biaoxiaodanBingqingTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=biaoxiaodan_yiliaofeiyong_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.biaoxiaodanYiliaofeiyongTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=biaoxiaodan_yesno_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.biaoxiaodanYesnoTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `caikuai/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.caikuaiOptions = data.data.list;
            }
         });
         this.$http({
             url: `yonghu/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.yonghuOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            caikuaiChange(id){
                this.$http({
                    url: `caikuai/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.caikuaiForm = data.data;
                    }
                });
            },
            yonghuChange(id){
                this.$http({
                    url: `yonghu/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.yonghuForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `biaoxiaodan/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.caikuaiChange(data.data.caikuaiId)
                        _this.yonghuChange(data.data.yonghuId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`biaoxiaodan/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.biaoxiaodanCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.biaoxiaodanCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片
            biaoxiaodanBaoxiaorenPhotoUploadChange(fileUrls){
                this.ruleForm.biaoxiaodanBaoxiaorenPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },
            biaoxiaodanBaoxiaorenShenfenzhengzPhotoUploadChange(fileUrls){
                this.ruleForm.biaoxiaodanBaoxiaorenShenfenzhengzPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },
            biaoxiaodanBaoxiaorenShenfenzhengfPhotoUploadChange(fileUrls){
                this.ruleForm.biaoxiaodanBaoxiaorenShenfenzhengfPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },
            biaoxiaodanFileUploadChange(fileUrls){
                this.ruleForm.biaoxiaodanFile = fileUrls;
                this.addEditUploadStyleChange()
            },

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}</style>

